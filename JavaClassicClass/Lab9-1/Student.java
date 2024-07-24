public class Student {
    private int studentNo;
    private String name;
    private double point;
    private String departmentName;
    private String cellphone;
    private String email;
    private String address;
    private String emergencyContact;

    private Student(Builder builder) {
        this.studentNo = studentNo;
        this.name = name;
        this.point = point;
        this.departmentName = departmentName;
        this.cellphone = cellphone;
        this.email = email;
        this.address = address;
        this.emergencyContact = emergencyContact;
    }

    public static class Builder {
        private int studentNo;
        private String name;
        private double point;
        private String departmentName;
        private String cellphone;
        private String email;
        private String address;
        private String emergencyContact;

        public Builder studentNo(int studentNo) {
            this.studentNo = studentNo;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder point(double point) {
            this.point = point;
            return this;
        }

        public Builder departmentName(String departmentName) {
            this.departmentName = departmentName;
            return this;
        }

        public Builder cellphone(String cellphone) {
            this.cellphone = cellphone;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }
        
        public Builder address(String address) {
            this.address = address;
            return this;
        }
        
        public Builder emergencyContact(String emergencyContact) {
            this.emergencyContact = emergencyContact;
            return this;
        }

        public Student build() {
            return new Student(this);
        }
    }
}
