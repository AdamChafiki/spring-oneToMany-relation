package ma.est.lp.service;

import ma.est.lp.bean.Post;
import ma.est.lp.bean.User;
import ma.est.lp.dao.PostDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostDao postDao;
    @Autowired
    private UserService userService;

    public Post getPostById(long id) {
        return postDao.findById(id).orElse(null);
    }

    public Post SavePost(Post post) {
        User user = userService.getUserById(post.getUser().getId());
        if (user == null) {
            return null;
        }
        post.setUser(user);
        return postDao.save(post);
    }

    public List<Post> GetAllPost() {
        return postDao.findAll();
    }

    public Post updateUser(Post updatePost,Long id) {
        Post post = postDao.findById(id)
                .orElseThrow(() -> new RuntimeException("Post not found"));
        post.setTitle(updatePost.getTitle());
        post.setContent(updatePost.getContent());
        return postDao.save(post);
    }


    public int deleteUser(Long id) {
        Post post = postDao.findById(id).orElse(null);
        if (post == null) {
            return 0;
        }
        postDao.deleteById(post.getId());
        return 1;
    }

}
