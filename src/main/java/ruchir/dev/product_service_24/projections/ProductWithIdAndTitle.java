package ruchir.dev.product_service_24.projections;


// Projection interface for retrieving product ID and title
public interface ProductWithIdAndTitle {

    Long getId();
    String getTitle();
}
