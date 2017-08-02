package pro.model.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "TRACE_FILE")
public class TraceFile implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @ManyToOne
    @JoinColumn(name="userId")
    private User user;

    @Column(name = "filename")
    private String filename;

    @Column(name = "filePath")
    private String filePath;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "TraceFile{" + "id=" + id +
                ", filename='" + filename + '\'' +
                ", filePath='" + filePath + '\'' +
                '}';
    }
}
