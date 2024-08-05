package io.whatap.sample.r2dbc.post;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@Service
@Transactional
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    //crud
    public Mono<Post> save(Post post) {
        return postRepository.save(post);
    }

    public Flux<Post> findAll() {
        return postRepository.findAll();
    }

    public Mono<Post> findById(Long id) {
        return postRepository.findById(id);
    }

    public Mono<Void> deleteById(Long id) {
        return postRepository.deleteById(id);
    }

    //Scheduler crud
    public Mono<Post> saveScheduler(Post post) {
        return postRepository.save(post).subscribeOn(Schedulers.boundedElastic());
    }

    public Flux<Post> findAllScheduler() {
        return postRepository.findAll().subscribeOn(Schedulers.boundedElastic());
    }

    public Mono<Post> findByIdScheduler(Long id) {
        return postRepository.findById(id).subscribeOn(Schedulers.boundedElastic());
    }

    public Mono<Void> deleteByIdScheduler(Long id) {
        return postRepository.deleteById(id).subscribeOn(Schedulers.boundedElastic());
    }
}
