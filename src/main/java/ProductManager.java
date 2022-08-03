public class ProductManager {

    private Product[] products = new Product[0];

    public void add(Product product) {
        int length = products.length + 1;
        Product[] tmp = new Product[length];
        System.arraycopy(products, 0, tmp, 0, products.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = product;
        products = tmp;


    }

    public Product[] findAll() {
        return products;
    }


    public Product[] findById1(int id1) {

        Product[] productById1 = new Product[0];

        for (Product product : findAll()) {
            if (product.getId() == id1) {
                Product[] tmp1 = new Product[productById1.length + 1];
                System.arraycopy(products, 0, tmp1, 0, productById1.length);
                int lastIndex1 = 0;
                tmp1[lastIndex1] = product;
                productById1 = tmp1;
                return productById1;
            }


        }


        return null;
    }


    public void removeById(int id) {
        if (findById1(id) == null) {
            throw new NotFoundException("Element with id: " + id + " not found");
        } else {

            int length1 = products.length - 1;
            Product[] tmp2 = new Product[length1];
            int index = 0;
            for (Product product : products) {

                if (product.getId() != id) {
                    tmp2[index] = product;
                    index++;

                }
                products = tmp2;
            }


        }
    }


    public Product[] searchBy(String search) {
        Product[] result = new Product[0]; // тут будем хранить подошедшие запросу продукты
        for (Product product : products) {
            if (product.matches(search)) {
                Product[] tmp = new Product[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[tmp.length - 1] = product;
                result = tmp;


            }
        }
        return result;
    }


    // метод определения соответствия товара product запросу search


}
