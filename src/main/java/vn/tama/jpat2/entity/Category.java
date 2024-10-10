package vn.tama.jpat2.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name="categories")
@NamedQuery(name="Category.findAll", query="SELECT c FROM Category c")

public class Category implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Categoryid")
    private int categoryid;

    @Column(name="Categoryname", columnDefinition = "nvarchar(50) not null")
    @NotEmpty(message = "Không được bỏ trống")
    private String categoryname;

    @Column(name="images", columnDefinition = "nvarchar(50) not null")
    private String images;

    //bi-directional many-to-one association to Video
    @OneToMany(mappedBy="category")
    private List<Video> videos;

    private int status;

    public Video addVideo(Video video) {
        getVideos().add(video);
        video.setCategory(this);
        return video;
    }

    public Video removeVideo(Video video) {
        getVideos().remove(video);
        video.setCategory(null);
        return video;
    }
}
