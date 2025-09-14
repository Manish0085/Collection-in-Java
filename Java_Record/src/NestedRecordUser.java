public record NestedRecordUser(String name, int age) {

    /*
        Nested Record:
        --------------

            - So in records, we can also create nested records, which can be private/protected, public
              like nested classes.
            - Only difference is, in record static nested record are possible and non-static nested records
              are not possible.
     */


    // by default iit is static
    record NestedAddressRecord(){

        public void display(){
            System.out.println("Hello inside  nested static record");
        }
    }


}
