package com.ardamecik.huginn.web.controller;

import com.ardamecik.huginn.core.model.TransferRecord;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Controller
public class DashboardController {

    private static final String DEVELOPER = "Arda Mecik";
    private static final List<TransferRecord> transferHistory = new ArrayList<>();

    static {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
        transferHistory.add(new TransferRecord("secret_doc.txt", "TXT", "SECURE", LocalDateTime.now().format(dtf), 59));
        transferHistory.add(new TransferRecord("vault_key.png", "IMG", "ENCRYPTED", LocalDateTime.now().minusMinutes(5).format(dtf), 54));
        transferHistory.add(new TransferRecord("system_core.bin", "BIN", "CRITICAL", LocalDateTime.now().minusMinutes(12).format(dtf), 48));
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("developer", DEVELOPER);
        model.addAttribute("systemStatus", "OPERATIONAL");
        model.addAttribute("transfers", transferHistory);
        return "dashboard";
    }
}