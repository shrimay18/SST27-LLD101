package com.example.imports;

public class CsvProfileImporter implements ProfileImporter {
    private final NaiveCsvReader reader;
    private ProfileService service;

    public CsvProfileImporter(NaiveCsvReader reader, ProfileService service) {
        this.reader = reader;
        this.service = service;
    }

    @Override
    public int importFrom(java.nio.file.Path csvPath) {
        java.util.List<String[]> records = reader.read(csvPath);
        int count = 0;
        int rowCount = 0;
        for (String[] record : records) {
            // Assuming CSV format: id, firstName, lastName, email
            if(rowCount == 0) {
                // Skip header row
                rowCount++;
                continue;
            }

            // if(record.length < 3) {
            //     System.out.println("Skipping row " + rowCount + ": insufficient data");
            //     rowCount++;
            //     continue;
            // }
            String id = record[0];
            String email = record[1];
            String displayName = record[2];

            if(id == null || id.isBlank())  {
                // Skip invalid records
                System.out.println("Skipping row " + rowCount + ": missing id");
            }
            else if(email == null || email.isBlank() || !email.contains("@")) {
                // Skip invalid records
                System.out.println("Skipping row " + rowCount + ": invalid email");
                continue;
            }
            else{
                service = new ProfileService();
                service.createProfile(id, email, displayName);
                count++;
            }
            rowCount++;
        }
        return count;
    }
}
