package Viewer;


public enum View {
    WELCOME("../FXMLWelcome.fxml"),
    LOGIN("../FXMLLogin.fxml"),
    REGISTER("../FXMLRegistration.fxml"),
    TRANSACTION("../FXMLTransaction.fxml"),
    DEPOSIT("../FXMLDeposit.fxml"),
    WITHDRAW("../FXMLWithdraw.fxml");

    private String fileName;

    View(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }
}
