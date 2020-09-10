package beans;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Category {

    @SerializedName("id")
    @Expose
    private Integer id;

    @SerializedName("name")
    @Expose
    private String name;


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


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Category{");
        sb.append("name='").append(name).append('\'');
        sb.append(", id=").append(id).append('\'');
        sb.append('}');
        return sb.toString();
    }


    @Override
    public int hashCode() {
        int result = 1;
        result = ((result* 31)+((this.id == null)? 0 :this.id.hashCode()));
        result = ((result* 31)+((this.name == null)? 0 :this.name.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Category) == false) {
            return false;
        }
        Category rhs = ((Category) other);
        return ((((((((this.id == rhs.id)||((this.id!= null)&&this.id.equals(rhs.id)))&&((this.name == rhs.name)||((this.name!= null)&&this.name.equals(rhs.name)))))))));
    }



}