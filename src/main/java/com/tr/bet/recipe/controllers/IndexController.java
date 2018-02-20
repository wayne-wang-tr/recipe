package com.tr.bet.recipe.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.File;

@Controller
public class IndexController {

    @RequestMapping({"", "", "/index"})
    public String getIndexPage() {

        File dir = new File("e:\\movie");
        show(dir, 0);
        return "index";
    }

    private void show(File file, int count) {
        if (file.isFile()) {
            for (int i = 0; i < count; i++) {
                System.out.print("    ");
            }
            System.out.println(file.getName());
            tokyoHot(file);
            thz(file);
            return;
        }

        for (int i = 0; i < count; i++) {
            System.out.print("    ");
        }
        System.out.println("[" + file.getName() + "]");

        count++;
        for (File f : file.listFiles()) {
            show(f, count);
        }
        count--;
    }

    private void tokyoHot(File file) {
        if (file.getParentFile().getName().contains("Tokyo Hot") && file.getName().substring(0, 1).equals("n")) {
            String str = file.getName().substring(1, 5);
            String absoluteDir = file.getParentFile().getAbsolutePath();
            String suffix = file.getName().substring(file.getName().indexOf('.'));
            String newName = absoluteDir + "\\Tokyo Hot " + str + suffix;
            file.renameTo(new File(newName));
        }
    }

    private void thz(File file) {
        String name = file.getName();
        if (name.contains("[") && name.contains("]")) {
            int idx1 = name.indexOf("[");
            int idx2 = name.indexOf("]");

            String newName = name.substring(idx2 + 1);
            String absoluteDir = file.getParentFile().getAbsolutePath();
            newName = absoluteDir + "\\" + newName;
            System.out.println(newName);
            file.renameTo(new File(newName));
        }

        if (file.getParentFile().getName().contains("Cover")) {
            String upperName = file.getName().toUpperCase();
            String absoluteDir = file.getParentFile().getAbsolutePath();
            String newName = absoluteDir + "\\" + upperName;
            System.out.println(newName);

            name = file.getName();
            int count = 0;
            name.chars().forEach(value -> {
            });
        }

    }
}
