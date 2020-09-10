package beans;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Objects;

public class PetModel {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("category")
    @Expose
    private Category category;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("photoUrls")
    @Expose
    private List<String> photoUrls;
    @SerializedName("tags")
    @Expose
    private List<Tags> tags;
    @SerializedName("status")
    @Expose
    private String status;

    public PetModel(Integer id, String name, Category category, List<String> photoUrls, List<Tags> tags, String
            status) {

        this.id = id;
        this.name = name;
        this.category = category;
        this.photoUrls = photoUrls;
        this.tags = tags;
        this.status = status;
    }

    private PetModel(Builder builder) {
        setId(builder.id);
        setName(builder.name);
        setCategory(builder.category);
        setPhotoUrls(builder.photoUrls);
        setTags(builder.tags);
        setStatus(builder.status);
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public List<String> getPhotoUrls() {
        return photoUrls;
    }

    public void setPhotoUrls(List<String> photoUrls) {
        this.photoUrls = photoUrls;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Tags> getTags() {
        return tags;
    }

    public void setTags(List<Tags> tags) {
        this.tags = tags;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public static enum Status {

        AVAILABLE, UNAVAILABLE

    }

    public static final class Builder {
        private Integer id;
        private String name;
        private Category category;
        private List<String> photoUrls;
        private List<Tags> tags;
        private String status;

        private Builder() {
        }

        public Builder withPhotoUrls(List<String> val) {
            photoUrls = val;
            return this;
        }

        public Builder withName(String val) {
            name = val;
            return this;
        }

        public Builder withId(Integer val) {
            id = val;
            return this;
        }

        public Builder withCategory(Category val) {
            category = val;
            return this;
        }

        public Builder withTags(List<Tags> val) {
            tags = val;
            return this;
        }

        public Builder withStatus(String val) {
            status = val;
            return this;
        }

        public PetModel build() {
            return new PetModel(this);
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PetModel{");
        sb.append("photoUrls=").append(photoUrls);
        sb.append(", name='").append(name).append('\'');
        sb.append(", id=").append(id);
        sb.append(", category=").append(category);
        sb.append(", tags=").append(tags);
        sb.append(", status='").append(status).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(category, id, name, photoUrls, status, tags);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PetModel that = (PetModel) o;

        return Objects.equals(this.category, that.category) &&
                Objects.equals(this.id, that.id) &&
                Objects.equals(this.name, that.name) &&
                Objects.equals(this.photoUrls, that.photoUrls) &&
                Objects.equals(this.status, that.status) &&
                Objects.equals(this.tags, that.tags);
    }

}