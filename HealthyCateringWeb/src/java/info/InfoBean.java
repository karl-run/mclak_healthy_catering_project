/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info;

import java.io.Serializable;
import java.util.ArrayList;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Any;
import javax.faces.application.Application;
import javax.faces.application.ViewHandler;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import locale.MessageHandler;
import locale.MessageType;
import shopping.customer.CorporateCustomer;
import shopping.customer.Customer;
import shopping.customer.PrivateCustomer;
import shopping.product.PackageProduct;
import shopping.product.Product;
import shopping.product.SingleProduct;
import user.User;

/**
 *
 * @author Karl
 */
@Any
@Named
@SessionScoped
public class InfoBean implements Serializable {

    private Customer selectedCustomer;
    private Customer selectedOrderCustomer;
    private Order selectedOrder;
    private Product selectedProduct;
    private int selectedSingleProductID;
    private boolean detailOrder;
    private boolean editCustomer;
    private boolean editProduct;
    private boolean showAddProduct;
    private boolean showActiveOrders;
    @Inject
    private CustomerHandler customerHandler;
    @Inject
    private ProductHandler productHandler;
    @Inject
    private OrderHandler orderHandler;

    public InfoBean() {
    }

    public ArrayList<Order> getActiveOrders() {
        return orderHandler.getActiveOrders();
    }

    public ArrayList<Order> getOrderHistory() {
        return orderHandler.getOrderHistory();
    }

    public void editCustomer(Customer customer) {
        selectedCustomer = customer;
        editCustomer = true;
    }

    public void lookUpOrder(int orderID) {
        selectedOrder = orderHandler.getOrderFromID(orderID);
        selectedOrderCustomer = orderHandler.getCustomerFromID(selectedOrder.getCustomerID());
        detailOrder = true;
    }

    public Customer getSelectedCustomer() {
        return selectedCustomer;
    }

    public Customer getSelectedOrderCustomer() {
        return selectedOrderCustomer;
    }

    public void setSelectedOrderCustomer(Customer selectedOrderCustomer) {
        this.selectedOrderCustomer = selectedOrderCustomer;
    }

    public Order getSelectedOrder() {
        return selectedOrder;
    }

    public boolean isCustomerOrder() {
        return detailOrder;
    }

    public boolean isPopupEditCustomer() {
        return editCustomer;
    }

    public void closeDetailedInfo() {
        selectedCustomer = null;
        detailOrder = false;
    }

    public void closeEditCustomer() {
        selectedCustomer = null;
        editCustomer = false;
        FacesContext context = FacesContext.getCurrentInstance();
        Application application = context.getApplication();
        ViewHandler viewHandler = application.getViewHandler();
        UIViewRoot viewRoot = viewHandler.createView(context, context
                .getViewRoot().getViewId());
        context.setViewRoot(viewRoot);
        context.renderResponse();
    }

    public void closeEditProduct() {
        selectedProduct = null;
        editProduct = false;
        FacesContext context = FacesContext.getCurrentInstance();
        Application application = context.getApplication();
        ViewHandler viewHandler = application.getViewHandler();
        UIViewRoot viewRoot = viewHandler.createView(context, context
                .getViewRoot().getViewId());
        context.setViewRoot(viewRoot);
        context.renderResponse();
    }

    public void closeAddProduct() {
        showAddProduct = false;
        FacesContext context = FacesContext.getCurrentInstance();
        Application application = context.getApplication();
        ViewHandler viewHandler = application.getViewHandler();
        UIViewRoot viewRoot = viewHandler.createView(context, context
                .getViewRoot().getViewId());
        context.setViewRoot(viewRoot);
        context.renderResponse();
    }

    public ArrayList<Customer> getAllCustomers() {
        return customerHandler.getAllCustomers();
    }

    public ArrayList<User> getAllUsers() {
        return null;
    }

    public ArrayList<Product> getAllProducts() {
        return productHandler.getAllProducts();
    }

    public String getFirstName() {
        if (selectedCustomer != null) {
            if (selectedCustomer instanceof PrivateCustomer) {
                PrivateCustomer customer = (PrivateCustomer) selectedCustomer;
                return customer.getFirstName();
            }
        }
        return null;
    }

    public void setFirstName(String firstname) {
        if (selectedCustomer != null) {
            if (selectedCustomer instanceof PrivateCustomer) {
                PrivateCustomer customer = (PrivateCustomer) selectedCustomer;
                customer.setFirstName(firstname);
            }
        }
    }

    public String getLastName() {
        if (selectedCustomer != null) {
            if (selectedCustomer instanceof PrivateCustomer) {
                PrivateCustomer customer = (PrivateCustomer) selectedCustomer;
                return customer.getLastName();
            }
        }
        return null;
    }

    public void setLastName(String lastname) {
        if (selectedCustomer != null) {
            if (selectedCustomer instanceof PrivateCustomer) {
                PrivateCustomer customer = (PrivateCustomer) selectedCustomer;
                customer.setLastName(lastname);
            }
        }
    }

    public String getCompanyName() {
        if (selectedCustomer != null) {
            if (selectedCustomer instanceof CorporateCustomer) {
                CorporateCustomer customer = (CorporateCustomer) selectedCustomer;
                return customer.getCompanyName();
            }
        }
        return null;
    }

    public void setCompanyName(String companyName) {
        if (selectedCustomer != null) {
            if (selectedCustomer instanceof CorporateCustomer) {
                CorporateCustomer customer = (CorporateCustomer) selectedCustomer;
                customer.setCompanyName(companyName);
            }
        }
    }

    public String getEmail() {
        if (selectedCustomer != null) {
            if (selectedCustomer instanceof PrivateCustomer) {
                PrivateCustomer customer = (PrivateCustomer) selectedCustomer;
                return customer.getEmail();
            } else if (selectedCustomer instanceof CorporateCustomer) {
                CorporateCustomer customer = (CorporateCustomer) selectedCustomer;
                return customer.getEmail();
            }
        }
        return null;
    }

    public void setEmail(String email) {
        if (selectedCustomer != null) {
            if (selectedCustomer instanceof PrivateCustomer) {
                PrivateCustomer customer = (PrivateCustomer) selectedCustomer;
                customer.setEmail(email);
            } else if (selectedCustomer instanceof CorporateCustomer) {
                CorporateCustomer customer = (CorporateCustomer) selectedCustomer;
                customer.setEmail(email);
            }
        }
    }

    public String getAddress() {
        if (selectedCustomer != null) {
            if (selectedCustomer instanceof PrivateCustomer) {
                PrivateCustomer customer = (PrivateCustomer) selectedCustomer;
                return customer.getAddress();
            } else if (selectedCustomer instanceof CorporateCustomer) {
                CorporateCustomer customer = (CorporateCustomer) selectedCustomer;
                return customer.getAddress();
            }
        }
        return null;
    }

    public void setAddress(String address) {
        if (selectedCustomer != null) {
            if (selectedCustomer instanceof PrivateCustomer) {
                PrivateCustomer customer = (PrivateCustomer) selectedCustomer;
                customer.setAddress(address);
            } else if (selectedCustomer instanceof CorporateCustomer) {
                CorporateCustomer customer = (CorporateCustomer) selectedCustomer;
                customer.setAddress(address);
            }
        }
    }

    public String getZipCode() {
        if (selectedCustomer != null) {
            if (selectedCustomer instanceof PrivateCustomer) {
                PrivateCustomer customer = (PrivateCustomer) selectedCustomer;
                return Integer.toString(customer.getZipCode());
            } else if (selectedCustomer instanceof CorporateCustomer) {
                CorporateCustomer customer = (CorporateCustomer) selectedCustomer;
                return Integer.toString(customer.getZipCode());
            }
        }
        return null;
    }

    public void setZipCode(String zip) {
        if (selectedCustomer != null) {
            if (selectedCustomer instanceof PrivateCustomer) {
                PrivateCustomer customer = (PrivateCustomer) selectedCustomer;
                try {
                    customer.setZipCode(Integer.parseInt(zip));
                } catch (Exception e) {
                }
            } else if (selectedCustomer instanceof CorporateCustomer) {
                CorporateCustomer customer = (CorporateCustomer) selectedCustomer;
                try {
                    customer.setZipCode(Integer.parseInt(zip));
                } catch (Exception e) {
                }
            }
        }
    }

    public String getCity() {
        if (selectedCustomer != null) {
            if (selectedCustomer instanceof PrivateCustomer) {
                PrivateCustomer customer = (PrivateCustomer) selectedCustomer;
                return customer.getCity();
            } else if (selectedCustomer instanceof CorporateCustomer) {
                CorporateCustomer customer = (CorporateCustomer) selectedCustomer;
                return customer.getCity();
            }
        }
        return null;
    }

    public void setCity(String city) {
        if (selectedCustomer != null) {
            if (selectedCustomer instanceof PrivateCustomer) {
                PrivateCustomer customer = (PrivateCustomer) selectedCustomer;
                customer.setCity(city);
            } else if (selectedCustomer instanceof CorporateCustomer) {
                CorporateCustomer customer = (CorporateCustomer) selectedCustomer;
                customer.setCity(city);
            }
        }
    }

    public String getPhoneNumber() {
        if (selectedCustomer != null) {
            if (selectedCustomer instanceof PrivateCustomer) {
                PrivateCustomer customer = (PrivateCustomer) selectedCustomer;
                return customer.getPhoneNumber();
            } else if (selectedCustomer instanceof CorporateCustomer) {
                CorporateCustomer customer = (CorporateCustomer) selectedCustomer;
                return customer.getPhoneNumber();
            }
        }
        return null;
    }

    public void setPhoneNumber(String number) {
        if (selectedCustomer != null) {
            if (selectedCustomer instanceof PrivateCustomer) {
                PrivateCustomer customer = (PrivateCustomer) selectedCustomer;
                customer.setPhoneNumber(number);
            } else if (selectedCustomer instanceof CorporateCustomer) {
                CorporateCustomer customer = (CorporateCustomer) selectedCustomer;
                customer.setPhoneNumber(number);
            }
        }
    }

    public boolean selectedLoggedInAsPrivate() {
        if (selectedCustomer instanceof PrivateCustomer) {
            return true;
        }
        return false;
    }

    public String saveChangesCustomer() {
        if (customerHandler.fixCustomer(selectedCustomer)) {
            String msg = MessageHandler.getLocalizedText(MessageType.TEKST, "edit_account_changes_saved");
            MessageHandler.addErrorMessage(msg);
        } else {
            String msg = MessageHandler.getLocalizedText(MessageType.ERROR, "edit_account_changes_not_saved");
            MessageHandler.addErrorMessage(msg);
        }
        return "";
    }

    /**
     * product_overview metoder
     *
     * @return
     */
    public Product getSelectedProduct() {
        return selectedProduct;
    }

    public boolean isEditProduct() {
        return editProduct;
    }

    public boolean selectedIsSingleProduct() {
        return selectedProduct instanceof SingleProduct;
    }

    public void setSelectedProduct(Product product) {
        if (product != null) {
            selectedProduct = product;
            editProduct = true;
        }
    }

    public boolean isShowAddProduct() {
        return showAddProduct;
    }

    public void setShowAddProduct(boolean showAddProduct) {
        this.showAddProduct = showAddProduct;
    }

    /**
     * SET & GET FOR PRODUCT (selectedProduct)
     *
     * @return
     */
    public String getProductName() {
        if (selectedProduct != null) {
            return selectedProduct.getName();
        }
        return null;
    }

    public void setProductName(String name) {
        if (selectedProduct != null && (!name.equals(""))) {
            selectedProduct.setName(name);
        }
    }

    public String getProductDescription() {
        if (selectedProduct != null) {
            return selectedProduct.getDescription();
        }
        return null;
    }

    public void setProductDescription(String desc) {
        if (selectedProduct != null && (!desc.equals(""))) {
            selectedProduct.setDescription(desc);
        }
    }

    public int getProductKCAL() {
        if (selectedProduct != null && (selectedProduct instanceof SingleProduct)) {
            SingleProduct singleProduct = (SingleProduct) selectedProduct;
            return singleProduct.getKcal();
        }
        return 0;
    }

    public void setProductKCAL(int KCAL) {
        if (selectedProduct != null && (selectedProduct instanceof SingleProduct)) {
            SingleProduct singleProduct = (SingleProduct) selectedProduct;
            singleProduct.setKcal(KCAL);
        }
    }

    public float getProductPrice() {
        if (selectedProduct != null && (selectedProduct instanceof SingleProduct)) {
            return selectedProduct.getPrice();
        }
        return 0;
    }

    public void setProductPrice(float price) {
        if (selectedProduct != null && (selectedProduct instanceof SingleProduct)) {
            SingleProduct singleProduct = (SingleProduct) selectedProduct;
            singleProduct.setPrice(price);
        }
    }

    public int getProductID() {
        if (selectedProduct != null) {
            return selectedProduct.getId();
        }
        return 0;
    }

    public int getProductDiscount() {
        if (selectedProduct != null && (selectedProduct instanceof PackageProduct)) {
            PackageProduct packageProduct = (PackageProduct) selectedProduct;
            return packageProduct.getDiscount();
        }
        return 0;
    }

    public void setProductDiscount(int discount) {
        if (selectedProduct != null && (selectedProduct instanceof PackageProduct)) {
            PackageProduct packageProduct = (PackageProduct) selectedProduct;
            packageProduct.setDiscount(discount);
        }
    }

    public ArrayList<SingleProduct> getPackageProducts() {
        if (selectedProduct != null && (selectedProduct instanceof PackageProduct)) {
            PackageProduct packageProduct = (PackageProduct) selectedProduct;
            return packageProduct.getProducts();
        }
        return null;
    }

    public ArrayList<Product> getAllSingleProducts() {
        ArrayList<Product> singleProducts = new ArrayList<Product>();
        for (Product p : getAllProducts()) {
            if (p instanceof SingleProduct) {
                singleProducts.add(p);
            }
        }
        return singleProducts;
    }

    public int getSelectedSingleProductID() {
        return selectedSingleProductID;
    }

    public void setSelectedSingleProductID(int selectedSingleProduct) {
        this.selectedSingleProductID = selectedSingleProduct;
    }

    /**
     * Save changes to a product
     */
    public String saveChangesProduct() {
        if (selectedProduct != null) {
            if (productHandler.updateProduct(selectedProduct)) {
                String msg = MessageHandler.getLocalizedText(MessageType.TEKST, "product_changes_saved");
                MessageHandler.addErrorMessage(msg);
            } else {
                String msg = MessageHandler.getLocalizedText(MessageType.TEKST, "product_changes_not_saved");
                MessageHandler.addErrorMessage(msg);
            }
        }
        return "";
    }

    public String addProductPackage() {
        SingleProduct selectedSingleProduct = null;
        for (Product sp : getAllSingleProducts()) {
            if (sp.getId() == selectedSingleProductID) {
                selectedSingleProduct = (SingleProduct) sp;
                break;
            }
        }
        if (selectedSingleProduct != null) {
            if (selectedProduct != null && (selectedProduct instanceof PackageProduct)) {
                PackageProduct packageProduct = (PackageProduct) selectedProduct;
                packageProduct.addProduct(selectedSingleProduct);
            }
        }
        return "";
    }

    public String deleteProductPackage(Product product) {
        if (product != null && (product instanceof SingleProduct)) {
            SingleProduct singleProduct = (SingleProduct) product;
            PackageProduct packageProduct = (PackageProduct) selectedProduct;
            packageProduct.removeProduct(singleProduct);
        }
        return "";
    }

    public boolean isShowActiveOrders() {
        return showActiveOrders;
    }

    public void setShowActiveOrders(boolean showActiveOrders) {
        this.showActiveOrders = showActiveOrders;
    }
    
}