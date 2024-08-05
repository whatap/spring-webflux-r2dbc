package io.whatap.sample.r2dbc.post;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping("/{id}")
    public Mono<Post> getPost(@PathVariable Long id) {
        return postService.findById(id);
    }

    @GetMapping("/all")
    public Flux<Post> getAllPosts() {
        return postService.findAll();
    }

    @PostMapping
    public Mono<Post> createPost(@RequestBody Post post) {
        return postService.save(post);
    }

    @DeleteMapping("/delete/{id}")
    public Mono<Void> deletePost(@PathVariable Long id) {
        return postService.deleteById(id);
    }

    @GetMapping("/sc/{id}")
    public Mono<Post> getPostScheduler(@PathVariable Long id) {
        return postService.findByIdScheduler(id);
    }

    @GetMapping("/sc/all")
    public Flux<Post> getAllPostsScheduler() {
        return postService.findAllScheduler();
    }

    @PostMapping("/sc")
    public Mono<Post> createPostScheduler(@RequestBody Post post) {
        return postService.saveScheduler(post);
    }

    @DeleteMapping("/sc/delete/{id}")
    public Mono<Void> deletePostScheduler(@PathVariable Long id) {
        return postService.deleteByIdScheduler(id);
    }
}
