public interface DbHandler {
    
    public String url="";
    public String username="";
    public String password="";

    public void save(String query);
    public void update(String query);
    public void create(String query);
    public void retrieve(String query);
    public void delete(String query);
}
