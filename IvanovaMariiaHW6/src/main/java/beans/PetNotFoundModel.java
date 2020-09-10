package beans;

import java.util.Objects;

public class PetNotFoundModel {

    private Integer code;
    private String type, message;

    public PetNotFoundModel(Integer code, String type, String message) {
        this.code = code;
        this.type = type;
        this.message = message;
    }

    public PetNotFoundModel() {
    }

    private PetNotFoundModel(Builder builder) {
        setCode(builder.code);
        setType(builder.type);
        setMessage(builder.message);
    }

    public static PetNotFoundModel.Builder newBuilder() {
        return new PetNotFoundModel.Builder();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static final class Builder {
        private Integer code;
        private String type;
        private String message;

        public PetNotFoundModel.Builder withCode(Integer val) {
            code = val;
            return this;
        }

        public PetNotFoundModel.Builder withType(String val) {
            type = val;
            return this;
        }

        public PetNotFoundModel.Builder withMessage(String val) {
            message = val;
            return this;
        }

        public PetNotFoundModel build() {
            return new PetNotFoundModel(this);
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, type, message);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PetNotFoundModel that = (PetNotFoundModel) o;

        return Objects.equals(this.type, that.type) &&
                Objects.equals(this.code, that.code) &&
                Objects.equals(this.message, that.message);
    }

}