package org.shilshar;

    import java.io.*;
    import java.util.*;
     
    public class IsolatedCustPurchCatg {
        interface CustomerPurchase {
            String getCustomerId();
            String getProductCategory();
        }

        /*
         * Complete the function
         */
     
        static int countExclusiveCustomers(List<CustomerPurchase> customerPurchases) {
            
            //Create set of customers who only had unique purchase categories
            //Find which category is repeated the most in that set
            
            Set<CustomerPurchase> unqCustPrchs = new HashSet<>(customerPurchases);
            Set<String> singlePrchCusts = new HashSet<>();
            Map<String, Integer> unqPurCategs = new HashMap<>();
            
            int maxUnqPurCustCatgCount = 0;
            
            for(CustomerPurchase custPur : unqCustPrchs){
                if (singlePrchCusts.contains(custPur.getCustomerId())){
                    singlePrchCusts.remove(custPur.getCustomerId());
                }
                else{
                    singlePrchCusts.add(custPur.getCustomerId()); 
                }
                if (!unqPurCategs.keySet().contains(custPur.getProductCategory())){
                    unqPurCategs.put(custPur.getProductCategory(),0);
                }
            }
            
            for(CustomerPurchase custPur : unqCustPrchs){
                int count = 0;
                if (singlePrchCusts.contains(custPur.getCustomerId())){
                    count = unqPurCategs.get(custPur.getProductCategory());
                    unqPurCategs.put(custPur.getProductCategory(), ++count);
                    if (count > maxUnqPurCustCatgCount)
                        maxUnqPurCustCatgCount = count;
                }
                    
            }
            
            return maxUnqPurCustCatgCount;
     
        }
        
        public static void main(String[] args) throws IOException{
            Scanner in = new Scanner(System.in);
            final String fileName = System.getenv("OUTPUT_PATH");
            BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
            int res;
            final List<CustomerPurchase> _customerPurchases = new ArrayList<>();
            while (in.hasNext()) {
                _customerPurchases.add(_createCustomerPurchase(in.nextLine()));
            }        
            
            res = countExclusiveCustomers(_customerPurchases);
            bw.write(String.valueOf(res));
            bw.newLine();
            
            bw.close();
        }
     
        private static CustomerPurchase _createCustomerPurchase(String line) {
            final String[] split = line.split(" ");
            if (split.length != 2) {
                return null;
            }
            return new CustomerPurchase() {
                @Override
                public String getCustomerId() {
                    return split[0];
                }
                
                @Override
                public String getProductCategory() {
                    return split[1];
                }
            };
        }
    }
