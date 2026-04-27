package mini.utils;

public abstract class Menu {
    public enum MainMenu {
        SIGNUP(1), LOGIN(2), EXIT(3), UNKNOWN(0);
        private final int value;
        MainMenu(int value) {
            this.value = value;
        }

        public static MainMenu getMainMenu(int value) {
            for (MainMenu mainMenu : MainMenu.values()) {
                if (mainMenu.value == value) {
                    return mainMenu;
                }
            }
            return MainMenu.UNKNOWN;
        }
    }

    public enum SubMenu {
        USER_INFO(1), All_PRODUCTS(2), SEARCH_PRODUCT(3),
        REGISTER_PRODUCT(4), MY_PRODUCT(5), MY_ORDER(6),
        LOGOUT(7), UNKNOWN(0);

        private final int value;
        SubMenu(int value) {
            this.value = value;
        }

        public static SubMenu getSubMenu(int value) {
            for (SubMenu subMenu : SubMenu.values()) {
                if (subMenu.value == value) {
                    return subMenu;
                }
            }
            return UNKNOWN;
        }
    }

}
