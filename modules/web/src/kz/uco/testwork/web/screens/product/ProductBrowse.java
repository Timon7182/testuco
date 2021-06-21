package kz.uco.testwork.web.screens.product;

import com.haulmont.cuba.gui.screen.*;
import kz.uco.testwork.entity.Product;

@UiController("testwork_Product.browse")
@UiDescriptor("product-browse.xml")
@LookupComponent("productsTable")
@LoadDataBeforeShow
public class ProductBrowse extends StandardLookup<Product> {
}