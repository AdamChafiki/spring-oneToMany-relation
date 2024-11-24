package ma.est.lp.ws;


import ma.est.lp.bean.Post;
import ma.est.lp.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class PostWs {

    @Autowired
    PostService postService;

    @PostMapping("post")
    public Post createPost(@RequestBody Post post) {
        return postService.SavePost(post);
    }


    @GetMapping("/post/{postId}")
    public Post getPost(@PathVariable long postId) {
        return postService.getPostById(postId);
    }

    @GetMapping("post")
    public List<Post> getPosts() {
        return postService.GetAllPost();
    }

    @PutMapping("post/{postId}")
    public Post save(@PathVariable long postId, @RequestBody Post post) {
        return postService.updateUser(post, postId);
    }

    @DeleteMapping("post/{postId}")
    public int save(@PathVariable long postId) {
        return postService.deleteUser(postId);
    }

}
