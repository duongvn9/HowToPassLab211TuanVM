public class Customer {
    String customerName;

    public Customer(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Customer other = (Customer) obj;
        return this.customerName.equalsIgnoreCase(other.customerName);
    }

    @Override
    public int hashCode() {
        return this.customerName.toLowerCase().hashCode();
    }
}