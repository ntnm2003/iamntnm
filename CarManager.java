
import Controller.BrandList;
import Controller.CarList;
import Controller.Menu;
import java.util.ArrayList;

public class CarManager {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        ArrayList<String> ops = new ArrayList<>();
        ops.add("List all brands");
        ops.add("Add a new brand");
        ops.add("Search a brand based on its ID");
        ops.add("Update a brand");
        ops.add("Save brands to the file, named brands.txt");
        ops.add("List all cars in ascending order of brand names");
        ops.add("List cars based on a part of an input brand name");
        ops.add("Add a car");
        ops.add("Remove a car based on its ID");
        ops.add("Update a car based on its ID");
        ops.add("Save cars to file, named cars.txt");
        ops.add("Exit");
        
        Menu menu = new Menu();
        BrandList brandList = new BrandList();
        brandList.loadFromFile("src/assets/brands.txt");
        CarList carList = new CarList(brandList);
        carList.loadFromFile("src/assets/cars.txt");
        
        int choice;
        
        do {
            System.out.println("----------MENU MINH TRANG BMW-----------");
            choice = menu.int_getChoice(ops);
            switch (choice) {
                case 1: {
                    brandList.listBrands();
                    System.out.println("Showed successfully!");
                    break;
                }
                case 2: {
                    brandList.addBrand();
                    System.out.println("Added succesfully!");
                    break;
                }
                case 3: {
                    String brandID = Validation.Inputter.inputString("Enter brand ID: ", false);
                    int index = 0;
                    index = brandList.searchID(brandID);
                    if (index == -1) {
                        System.out.println("Not found!");
                    } else {
                        System.out.println(brandList.get(index));
                        System.out.println("Brand result is shown.");
                    }
                    break;
                }case 4: {
                    brandList.updateBrand();
                    System.out.println("Update successfully!");
                    break;
                }case 5: {
                    brandList.saveToFile("src/assets/brands.txt");
                    System.out.println("File saved!");
                    break;
                }
                case 6: {
                    carList.listCars();
                    System.out.println("Showed successfully!");
                    break;
                }
                case 7: {
                    carList.printBasedBrandName();  
                    break;
                }
                case 8: {
                    carList.addCar();
                    System.out.println("Added successfully!");
                    break;
                }
                case 9: {
                    if (carList.removeCar()) {
                        System.out.println("Remove successfully!");
                    } 
                    break;
                }
                case 10: {
                    if (carList.updateCar()) {
                        System.out.println("Update successfully!");
                    }
                    break;
                }
                case 11: {
                    carList.saveToFile("src/assets/cars.txt");
                    System.out.println("File saved!");
                    break;
                }
            }
        } while (choice < ops.size());   
    }
}
