package mini.controllers;

import mini.DTO.ProductDTO;
import mini.DTO.UserDTO;
import mini.services.ProductService;
import mini.utils.AppException;
import mini.utils.SessionManager;

import java.util.List;

public class ProductController {
    private final SessionManager sessionManager;
    private final ProductService productService;

    public ProductController(ProductService productService, SessionManager sessionManager) {
        this.productService = productService;
        this.sessionManager = sessionManager;
    }

    public ProductDTO getProduct(long productId) { return productService.getProduct(productId); }

    public List<ProductDTO> showAllProducts() {
        return productService.getAllProducts();
    }

    public List<ProductDTO> searchProducts(String keyword) {
        return productService.searchProducts(keyword);
    }

    public List<ProductDTO> getMyProducts() {
        UserDTO currentUser = sessionManager.getCurrentUser();
        if (currentUser == null) {
            throw new AppException("[오류] 로그인이 필요합니다.");
        }
        return productService.getMyProducts(currentUser);
    }

    public void registerProduct(ProductDTO productDTO) {
        UserDTO currentUser = sessionManager.getCurrentUser();
        if (currentUser == null) {
            throw new AppException("[오류] 로그인이 필요합니다.");
        }
        productDTO.setUserDTO(currentUser);
        productService.registerProduct(productDTO, currentUser);
    }

    public void deleteProduct(long productId) {
        UserDTO currentUser = sessionManager.getCurrentUser();
        if (currentUser == null) {
            throw new AppException("[오류] 로그인이 필요합니다.");
        }
        if (productId == 0) throw new AppException("");
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(productId);
        productDTO.setUserDTO(currentUser);
        productService.deleteMyProduct(productDTO, currentUser.getId());
    }

    private boolean validate(ProductDTO productDTO) {
        UserDTO currentUser = sessionManager.getCurrentUser();
        if (currentUser == null || productDTO == null) return false;
        return productDTO.getUserDTO().getId() == currentUser.getId();
    }

    private void processUpdate(ProductDTO productDTO) {
        if (validate(productDTO)) {
            productService.editProduct(productDTO);
        } else {
            throw new AppException("[오류] 권한이 없거나 잘못된 접근입니다.");
        }
    }

    public void updateProductName(ProductDTO productDTO, String name) {
        productDTO.setProductName(name);
        processUpdate(productDTO);
    }

    public void updateProductDescription(ProductDTO productDTO, String desc) {
        productDTO.setProductDescription(desc);
        processUpdate(productDTO);
    }

    public void updateProductPrice(ProductDTO productDTO, double price) {
        productDTO.setProductPrice(price);
        processUpdate(productDTO);
    }

    public void updateProductQuantity(ProductDTO productDTO, int quantity) {
        productDTO.setQuantity(quantity);
        processUpdate(productDTO);
    }


}
