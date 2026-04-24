package mini.jdbc.views;

import mini.jdbc.DTO.ProductDTO;
import mini.jdbc.DTO.UserDTO;
import mini.jdbc.controllers.OrderController;
import mini.jdbc.controllers.ProductController;
import mini.jdbc.controllers.UserController;
import mini.jdbc.utils.InputUtil;

import java.util.List;

public class ProductView {
    UserController userController = new UserController();
    ProductController productController = new ProductController();
    OrderController orderController = new OrderController();

    private void displayAndHandleProductList(List<ProductDTO> productList, String title) {
        System.out.println("\n[" + title + "]");
        if (productList.isEmpty()) {
            System.out.println("등록된 상품이 없습니다.");
        } else {
            for (ProductDTO p : productList) {
                System.out.printf("ID: %d |명칭: %s |가격: %.0f |재고: %d |판매자: %s\n",
                        p.getId(), p.getProductName(), p.getProductPrice(), p.getQuantity(),
                        p.getUserDTO().getUsername());
            }
        }
    }

    public void showAllProducts(){
        System.out.println("[Info] all products");
        List<ProductDTO> allProducts = productController.showAllProducts();
        displayAndHandleProductList(allProducts, "[ 전체 상품 ]");
        int menu = InputUtil.readInt("1. 상품 상세 보기/구매 | 2. 뒤로가기");
        if (menu == 1) {
            long productId = InputUtil.readInt("조회할 상품 ID를 입력하세요");
            showProductDetailAndBuy(productId); // 상세 페이지로 이동
        }
    }

    public void showProductDetailAndBuy(long productId) {
        ProductDTO product = productController.getProduct(productId);
        UserDTO currentUser = userController.getUser();

        if (product == null) {
            System.out.println("해당 상품이 존재하지 않습니다.");
            return;
        }
        System.out.println("\n=== 상품 상세 정보 ===");
        System.out.println("명칭: " + product.getProductName());
        System.out.println("가격: " + product.getProductPrice());
        System.out.println("설명: " + product.getProductDescription());
        System.out.println("수량: " + product.getQuantity());

        int choice = InputUtil.readInt("1. 구매 결정 | 2. 취소");
        if (choice == 1) {
            int orderCount = InputUtil.readInt("수량을 선택하세요.");
            orderController.createOrder(currentUser,  product, orderCount);
        }
    }

    public void searchProducts(){
        System.out.println("[Info] search products");
        String keyword = InputUtil.readString("검색 키워드를 입력하세요");
        List<ProductDTO> result = productController.searchProducts(keyword);
        displayAndHandleProductList(result, "[ 검색 결과 ]");
    }

    public void addProductView() {
        System.out.println("\n[ 상품 등록 ]");
        String name = InputUtil.readString("상품명");
        if (name.equals("0")) return;

        double price = InputUtil.readDouble("가격");
        int quantity = InputUtil.readInt("수량");
        String desc = InputUtil.readString("설명");

        ProductDTO newProduct = new ProductDTO();
        newProduct.setProductName(name);
        newProduct.setProductDescription(desc);
        newProduct.setProductPrice(price);
        newProduct.setQuantity(quantity);

        productController.registerProduct(newProduct);
    }

    public void showMyProducts(){
        System.out.println("[Info] my products");
        productController.showMyProducts();
        int menu = InputUtil.readInt("1. 상품 정보 수정 | 2. 뒤로가기");
        if (menu == 1) {
            long productId = InputUtil.readInt("수정할 상품 ID를 입력하세요");
            updateProductView(productId); // 상세 페이지로 이동
        }
    }

    public void updateProductView(long productId) {
        System.out.println("\n[ 상품 수정 ]");
        int option = InputUtil.readInt("1.상품명 변경 | 2.상품설명 변경 | 3.가격변경 | 4.재고변경 | 5.상품삭제 | 6.뒤로가기 ");
        ProductDTO productDTO = productController.getProduct(productId);
        switch (option) {
            case 1:
                String name = InputUtil.readString("변경할 상품명을 입력하세요");
                productController.updateProductName(productDTO, name);
                break;
            case 2:
                String desc = InputUtil.readString("변경할 상품설명을 입력하세요");
                productController.updateProductDescription(productDTO, desc);
                break;
            case 3:
                double price = InputUtil.readDouble("변경할 상품가격을 입력하세요");
                productController.updateProductPrice(productDTO, price);
                break;
            case 4:
                int quantity = InputUtil.readInt("변경할 재고를 입력하세요");
                productController.updateProductQuantity(productDTO, quantity);
                break;
            case 5:
                if(productController.deleteProduct(productId)){
                    break;
                }
            case 6:
                break;
        }
    }

}
