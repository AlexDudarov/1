package gmail.alexdudarkov.sportshop.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Calendar;
@Entity
@Table(name = "news")
public class News implements Serializable {
    private static final long serialVersionUID = 136969662390775361L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "news_id")
    private Long id;
    @Column(name = "title")
    private String title;
    @Column(name = "text")
    private String text;
    @Column(name = "icon_name")
    private String iconName;
    @Temporal(TemporalType.DATE)
    @Column(name = "date_news")
    private Calendar dateNews;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getIconName() {
        return iconName;
    }

    public void setIconName(String iconName) {
        this.iconName = iconName;
    }

    public Calendar getDateNews() {
        return dateNews;
    }

    public void setDateNews(Calendar dateNews) {
        this.dateNews = dateNews;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof News)) return false;

        News news = (News) o;

        if (id != null ? !id.equals(news.id) : news.id != null) return false;
        if (title != null ? !title.equals(news.title) : news.title != null) return false;
        if (iconName != null ? !iconName.equals(news.iconName) : news.iconName != null) return false;
        return dateNews != null ? dateNews.equals(news.dateNews) : news.dateNews == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (iconName != null ? iconName.hashCode() : 0);
        result = 31 * result + (dateNews != null ? dateNews.hashCode() : 0);
        return result;
    }
}
