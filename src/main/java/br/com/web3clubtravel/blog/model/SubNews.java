package br.com.web3clubtravel.blog.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "sub_news")
public class SubNews {

    @Id
    @Column(name = "id_sub_news")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSubNews;

    @Column(name = "sub_title")
    private String subTitle;

    @Column(name = "text")
    private String text;

    @Column(name = "image_link")
    private String imageLink;

    @Column(name = "image")
    private byte[] image;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "news", foreignKey = @ForeignKey(name = "fk_sub_news_news"))
    private News news;
}
