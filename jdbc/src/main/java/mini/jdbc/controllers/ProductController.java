package mini.jdbc.controllers;

import mini.jdbc.DTO.ProductDTO;
import mini.jdbc.DTO.UserDTO;
import mini.jdbc.services.ProductService;
import mini.jdbc.utils.SessionManager;

import java.util.List;

public class ProductController {
    private final SessionManager sessionManager = SessionManager.getInstance();
    ProductService productService = new ProductService();

    public ProductDTO getProduct(long productId) {
        return productService.getProduct(productId);
    }


    public List<ProductDTO> showAllProducts() {
        return productService.getAllProducts();
    }

    public List<ProductDTO> searchProducts(String keyword) {
        return productService.searchProducts(keyword);
    }


    public void showMyProducts() {
        UserDTO currentUser = sessionManager.getCurrentUser();
        if (currentUser == null) {
            System.out.println("먼저 로그인 해주세요.");
            return;
        }
        List<ProductDTO> list = productService.getMyProducts(currentUser);
        System.out.println("\n[ 나의 상품 내역 ]");
        if (list.isEmpty()) {
            System.out.println("등록된 상품이 없습니다.");
        } else {
            for (ProductDTO p : list) {
                System.out.println(p.getCreatedAt());
                System.out.printf("상품ID: %d |상품명: %s |상품가격: %.0f |상품수량: %d |날짜: %s\n",
                        p.getId(), p.getProductName(), p.getProductPrice(), p.getQuantity(), p.getCreatedAt());
            }
        }
    }

    public void registerProduct(ProductDTO productDTO) {
        UserDTO currentUser = sessionManager.getCurrentUser();
        if (currentUser == null) {
            System.out.println("로그인이 필요합니다.");
            return;
        }
        productDTO.setUserDTO(currentUser);
        productService.registerProduct(productDTO);
    }

    public boolean deleteProduct(long productId) {
        UserDTO currentUser = sessionManager.getCurrentUser();
        if (currentUser == null) {
            System.out.println("먼저 로그인 해주세요.");
            return false;
        }
        if (productId == 0) return false;
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(productId);
        productDTO.setUserDTO(currentUser);
        return productService.deleteMyProduct(productDTO, currentUser.getId());
    }

    private boolean validate(ProductDTO dto) {
        UserDTO currentUser = sessionManager.getCurrentUser();
        if (currentUser == null || dto == null) return false;

        return dto.getUserDTO().getId() == currentUser.getId();
    }

    private void processUpdate(ProductDTO productDTO) {
        if (validate(productDTO)) {
            boolean success = productService.editProduct(productDTO);
            if (success) System.out.println("[알림] 수정되었습니다.");
            else System.out.println("[오류] 수정 실패.");
        } else {
            System.out.println("[오류] 권한이 없거나 잘못된 접근입니다.");
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
