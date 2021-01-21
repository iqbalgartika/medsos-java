package medsos.post;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {

    private PostRepository postRepository;

    public PostController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @PostMapping
    public void addpost(@RequestBody Post post) {
        postRepository.save(post);
    }

    @GetMapping
    public List<Post> getposts() {
        return postRepository.findAll();
    }

    @DeleteMapping("/{id}")
    public void deletepost(@PathVariable String id) {
        Post postToDel = postRepository.findById(id);
        postRepository.delete(postToDel);
    }
}