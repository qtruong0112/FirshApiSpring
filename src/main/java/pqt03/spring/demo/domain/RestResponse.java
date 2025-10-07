package pqt03.spring.demo.domain;

public class RestResponse<T> {
    private int statusCode;
    private Object message;
    private String eror;
    private T data;

    public RestResponse() {
    }

    public RestResponse(int statusCode, Object message, String eror, T data) {
        this.statusCode = statusCode;
        this.message = message;
        this.eror = eror;
        this.data = data;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public Object getMessage() {
        return message;
    }

    public void setMessage(Object message) {
        this.message = message;
    }

    public String getEror() {
        return eror;
    }

    public void setEror(String eror) {
        this.eror = eror;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    
    
}
