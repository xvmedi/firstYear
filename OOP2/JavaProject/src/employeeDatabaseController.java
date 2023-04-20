import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.*;


public class employeeDatabaseController implements Initializable {

    private int selectedEmployeeID;

    private final String[] bannedCharacters = {" ", "!", "\"", "#", "$", "%", "&", "'", "(", ")", "*", "+", ",", "-", ".",
            "/", ":", ";", "<", "=", ">", "?", "@", "[", "]", "\\", "^", "_", "`", "{", "}", "|", "~"};

    private final List<Employee> employeeList = new ArrayList<>();

    private final List<String> jobTitleList = new ArrayList<>(), genders = new ArrayList<>();

    @FXML
    private Label IDErrorLabel;

    @FXML
    private TextField IDInput;

    @FXML
    private Label IDLabel;

    @FXML
    private Button addButton;

    @FXML
    private Button clearButton;

    @FXML
    private Button deleteButton;

    @FXML
    private Button deselectButton;

    @FXML
    private Label employeeToDelete;

    @FXML
    private RadioButton femaleButton;

    @FXML
    private RadioButton fullTime;

    @FXML
    private Label genderErrorLabel;

    @FXML
    private ToggleGroup genderGroup;

    @FXML
    private Label genderLabel;

    @FXML
    private Label jobErrorLabel;

    @FXML
    private Label jobLabel;

    @FXML
    private Label jobStatus;

    @FXML
    private Label jobStatusErrorLabel;

    @FXML
    private ToggleGroup jobStatusGroup;

    @FXML
    private ComboBox<String> jobTitles;

    @FXML
    private ComboBox<String> listFilters;

    @FXML
    private RadioButton maleButton;

    @FXML
    private Label nameErrorLabel;

    @FXML
    private TextField nameInput;

    @FXML
    private Label nameLabel;

    @FXML
    private Label numOfEmployees;

    @FXML
    private RadioButton otherButton;

    @FXML
    private RadioButton partTime;

    @FXML
    private ListView<Employee> recordList;

    @FXML
    private Button reset;

    @FXML
    private Button saveButton;

    @FXML
    private Label saveFileErrorLabel;


    //Starts/initializes the program
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //Builds the comboBoxes
        Collections.addAll(jobTitleList, "Director", "Manager", "Developer", "Tester", "Salesman");
        Collections.addAll(genders, "Male", "Female", "Other");
        jobTitles.getItems().addAll(jobTitleList);
        listFilters.getItems().addAll(jobTitleList);
        listFilters.getItems().addAll(genders);

        //Reads the file and updates the recordList
        readFile();
        updateRecordListView();

        //Allows for selection based updates (interactivity)
        recordList.getSelectionModel().selectedIndexProperty().addListener(ov -> {
            Employee employee = recordList.getSelectionModel().getSelectedItem();
            //Validation
            //Adding a null validation is what fixed the deselect function (Cam)
            if (!employeeList.isEmpty() && employee != null) {
                employeeToDelete.setText("Employee ID: " + employee.getId());
                selectedEmployeeID = employee.getId();
            } else {
                //Resets the employeeToDelete label and selectedEmployeeID value
                employeeToDelete.setText("Employee ID: ");
                selectedEmployeeID = 0;
            }
        });
        //Updates the number of employees
        numOfEmployees.setText("Number of Employees: " + employeeList.size());
    }

    //Adds an employee if they meet the given criteria
    @FXML
    void addEmployee(ActionEvent event) {
        Employee newEmployee;
        newEmployee = new Employee(0, nameInput.getText(),
                jobTitles.getValue(), getJobStatus(), getGender());
        boolean invalidID = false, foundInputError = false;
        try {
            newEmployee.setId(Integer.parseInt(IDInput.getText()));
        } catch (IllegalArgumentException ex) {
            invalidID = true;
            Tooltip IDErrorTooltip = new Tooltip("Invalid value, must be unique number");
            IDErrorLabel.setTooltip(IDErrorTooltip);
            IDErrorLabel.setText("*");
        }
        for (Employee e : employeeList)
            if (newEmployee.getId() == e.getId() && !invalidID) {
                IDInput.setText(null);
                Tooltip IDErrorTooltip = new Tooltip("ID: " + newEmployee.getId() + " taken");
                IDErrorLabel.setText("*");
                IDErrorLabel.setTooltip(IDErrorTooltip);
                foundInputError = true;
            }
        for (String bC : bannedCharacters)
            if (newEmployee.getName().contains(bC)) {
                nameInput.setText(null);
                nameErrorLabel.setText("*");
                Tooltip nameErrorToolTip = new Tooltip("Banned character: " + bC);
                nameErrorLabel.setTooltip(nameErrorToolTip);
                foundInputError = true;
            }
        if (newEmployee.getName() == null || newEmployee.getName().equals("")){
            nameErrorLabel.setText("*");
            Tooltip nameErrorToolTip = new Tooltip("Blank field, please enter a name.");
            nameErrorLabel.setTooltip(nameErrorToolTip);
            foundInputError = true;
        }

        if (newEmployee.getJobTitle() == null) {
            Tooltip jobTitleErrorTooltip = new Tooltip("Please select a job title.");
            jobErrorLabel.setText("*");
            jobErrorLabel.setTooltip(jobTitleErrorTooltip);
            foundInputError = true;
        }

        if (newEmployee.getJobStatus().equals("")) {
            Tooltip jobStatusErrorTooltip = new Tooltip("Please select a job status.");
            jobStatusErrorLabel.setText("*");
            jobStatusErrorLabel.setTooltip(jobStatusErrorTooltip);
            foundInputError = true;
        }

        if (newEmployee.getGender().equals("")) {
            Tooltip genderErrorTooltip = new Tooltip("Please select a gender.");
            genderErrorLabel.setText("*");
            genderErrorLabel.setTooltip(genderErrorTooltip);
            foundInputError = true;
        }

        if(foundInputError) return;

        employeeList.add(newEmployee);
        sortEmployeeList();
        updateRecordListView();
        numOfEmployees.setText("Number of Employees: " + employeeList.size());
        clearButton.fire();
    }

    //Clears all the fields for adding an employee
    @FXML
    void clearAllFields(ActionEvent event) {
        RadioButton off = new RadioButton();
        IDInput.setText("");
        nameInput.setText("");
        jobTitles.setValue(null);
        jobStatusGroup.getToggles().setAll(off, fullTime, partTime);
        genderGroup.getToggles().setAll(off, maleButton, femaleButton, otherButton);
        IDErrorLabel.setTooltip(null);
        IDErrorLabel.setText(null);
        nameErrorLabel.setTooltip(null);
        nameErrorLabel.setText(null);
        jobErrorLabel.setTooltip(null);
        jobErrorLabel.setText(null);
        jobStatusErrorLabel.setTooltip(null);
        jobStatusErrorLabel.setText(null);
        genderErrorLabel.setTooltip(null);
        genderErrorLabel.setText(null);
    }

    //Removes the selected employee from the database
    @FXML
    void deleteEmployee(ActionEvent event) {
        if (employeeList.isEmpty()) {
            selectedEmployeeID = 0;
            return;
        } else if (employeeList.size() == 1) {
            selectedEmployeeID = 0;
            employeeList.clear();
        } else {
            for (int i = 0; i < employeeList.size(); i++)
                if (employeeList.get(i).getId() == selectedEmployeeID) {
                    recordList.getItems().remove(employeeList.get(i));
                    employeeList.remove(employeeList.get(i));
                }
            deselectButton.fire();
        }
        recordList.refresh();
        numOfEmployees.setText("Number of Employees: " + employeeList.size());
    }

    //Un-highlights the current listview selection
    @FXML
    void deselectEmployee(ActionEvent event) {
        recordList.getSelectionModel().clearSelection();
        employeeToDelete.setText("Employee ID: ");
        selectedEmployeeID = 0;
    }

    @FXML
    void saveToCSV(ActionEvent event) {
        //Creates a reference to the file
        File employeeDatabase = new File("src/Employee_Database.csv");
        //Creates a temporary writer to output to the file
        try (PrintWriter employeeMaker = new PrintWriter(employeeDatabase)) {
            employeeMaker.print("");
            if (employeeList.isEmpty()) {
                return;
            }
            //Prints in CSV (comma separated value) format
            for (Employee newEmp : employeeList) {
                employeeMaker.println(newEmp.getId() + "," + newEmp.getName() + "," + newEmp.getJobTitle() +
                        "," + newEmp.getJobStatus() + "," + newEmp.getGender());
            }
        } catch (IOException ex) {
            Tooltip saveFileErrorTooltip = new Tooltip("There was an issue saving to the file.");
            saveFileErrorLabel.setText("*");
            saveFileErrorLabel.setTooltip(saveFileErrorTooltip);
        }
    }

    private void readFile() {
        //Removes the tooltip if there was previously an error reading the file
        recordList.setTooltip(null);
        //Creates a reference to a file
        File employeeDatabase = new File("src/Employee_Database.csv");
        //Creates a temporary file reader
        try (Scanner fileReader = new Scanner(employeeDatabase)) {
            //Continues reading the file so long as there's another line
            while (fileReader.hasNextLine()) {
                String line = fileReader.nextLine();
                String[] employeeInfoArray = line.split(",");
                //Creates an employee object in the array
                employeeList.add(new Employee(Integer.parseInt(employeeInfoArray[0]), employeeInfoArray[1],
                        employeeInfoArray[2], employeeInfoArray[3], employeeInfoArray[4]));
                sortEmployeeList();
            }
        } catch (IOException ex) {
            Tooltip fileReadErrorTooltip =
                    new Tooltip("There was an error reading/writing your file, or doesn't exist.");
            recordList.setTooltip(fileReadErrorTooltip);
        }
    }

    @FXML
    void filterEmployeeList(ActionEvent event) {
        String filter = listFilters.getValue();

        //Validation
        if (employeeList.isEmpty())
            return;
        //Clears the listView before adding the filtered results
        recordList.getItems().clear();
        for (Employee e : employeeList)
            if (e.getGender().contains(filter) || e.getJobStatus().contains(filter)
                    || e.getJobTitle().contains(filter) || e.getName().contains(filter))
                recordList.getItems().add(e); //Adding filtered employee
        //Refreshes the list
        recordList.refresh();
        //UpdateRecordListView isn't used here as it would set everything the default filter
    }

    //Resets the filters, displays all
    @FXML
    void resetFilters(ActionEvent event) {
        listFilters.setValue("");
        updateRecordListView();
    }

    private void sortEmployeeList() {
        Comparator<Employee> employeeIDComparator = Comparator.comparing(Employee::getId);
        employeeList.sort(employeeIDComparator);
    }

    //Used as a way to update the recordList (listView) with the employeeList
    private void updateRecordListView() {
        if (!recordList.getItems().isEmpty())
            recordList.getItems().clear();
        recordList.getItems().addAll(employeeList);
        recordList.refresh();
    }

    private String getJobStatus() {
        String jobStatus = "";
        if (fullTime.isSelected())
            jobStatus = "Full-Time";
        else if (partTime.isSelected())
            jobStatus = "Part-Time";
        return jobStatus;
    }

    private String getGender() {
        String gender = "";
        if (maleButton.isSelected())
            gender = "Male";
        else if (femaleButton.isSelected())
            gender = "Female";
        else if (otherButton.isSelected())
            gender = "other";
        return gender;
    }

}