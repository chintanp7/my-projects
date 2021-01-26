package com.chintan.sqlhelper;

import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class GenerateWhereClause {

    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the file location");

        String filePath = input.nextLine();

        String prefix = "('";
        String suffix = "')";
        String separator = ",";
        boolean newLineRequired = true;
        String outputFilePath = "C:\\Workspace\\my-projects\\test-project\\output\\output.txt";

        Path path = Paths.get(filePath);
        while (StringUtils.isEmpty(filePath) || !Files.exists(path) || !Files.isRegularFile(path)) {
            System.out.println("File path is not valid. Please enter valid file path");
            filePath = input.nextLine();
            path = Paths.get(filePath);
        }

        System.out.println("Please enter the prefix. Enter to select default: ('");
        String prefixParam = input.nextLine();
        if (StringUtils.isNoneBlank(prefixParam)) {
            prefix = prefixParam;
        }

        System.out.println("Please enter the suffix. Enter to select default: ')");
        String suffixParam = input.nextLine();
        if (StringUtils.isNoneBlank(suffixParam)) {
            suffix = suffixParam;
        }

        System.out.println("Please enter the separator. Enter to select default: ,");
        String separatorParam = input.nextLine();
        if (StringUtils.isNoneBlank(separatorParam)) {
            separator = separatorParam;
        }

        System.out.println("Select output option: 1 for single-line, 2 for multi-line:");
        newLineRequired = StringUtils.equals("2", input.nextLine());

        System.out.println("=============================================");
        System.out.println("Parameter values:");
        System.out.println("File Path: " + filePath);
        System.out.println("Prefix: " + prefix);
        System.out.println("Suffix: " + suffix);
        System.out.println("Separator: " + separator);
        System.out.println("Multi-line: " + newLineRequired);
        System.out.println("Press 1 to continue and 0 to exist.");
        System.out.println("=============================================");
        boolean shouldContinue = StringUtils.equals("1", input.nextLine());

        if (!shouldContinue) {
            System.out.println("Bye bye...");
            System.exit(0);
        }

        List<String> lines = Files.readAllLines(path);

        File file = new File(outputFilePath);
        if (file.exists()) {
            file.delete();
        }

        file.createNewFile();

        FileWriter fw = new FileWriter(outputFilePath);

        for (int i = 0; i < lines.size(); i++) {
            if (i == lines.size() - 1) {
                fw.write(prefix + lines.get(i) + suffix);
            } else {
                fw.write(prefix + lines.get(i) + suffix + separator);
            }

            if (newLineRequired) {
                fw.write("\n");
            }
        }

        fw.close();

    }
}
