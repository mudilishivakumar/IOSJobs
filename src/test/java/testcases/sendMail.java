package testcases;

import org.apache.commons.mail.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class sendMail extends BaseTest {

    public static void sendTestReportEmail(List<Map<String, String>> testResults)
            throws EmailException, IOException {
        System.out.println("========== Sending Test Report Email ==================");

        // Define report path
        String reportPath = System.getProperty("user.dir") + "/" + report1;
        File reportFile = new File(reportPath);

        // Upload to GitHub Pages
        GitHubUploader uploader = new GitHubUploader(
                "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",
                "TestSuitNative",
                "test-report",
                "main",
                "docs"
        );
        String githubPageUrl = uploader.upload(reportFile);
        System.out.println("📌 Report available at: " + githubPageUrl);

        // Configure email
        HtmlEmail email = new HtmlEmail();
        email.setHostName("smtp.gmail.com");
        email.setSmtpPort(587);
        email.setStartTLSEnabled(true);
        email.setSSLOnConnect(false);

        String senderEmail = "ddazn026@gmail.com";
        String appPassword = "igkp bsfw wnow pxhz"; // ⚠️ Use ENV variable

        email.setAuthenticator(new DefaultAuthenticator(senderEmail, appPassword));
        email.setFrom(senderEmail);
        email.setSubject("Automation Test Report ios/production/v2.44.8/#202507072133: Summary");

        // Recipients
        email.addCc("shivakumar.mudili@dazn.com");
       // email.addCc("Raghavendra.Udutha@dazn.com");
      //   email.addCc("Yashwanth.Sai@dazn.com");

        // Build email body
        StringBuilder emailBody = new StringBuilder();
        emailBody.append("<html><head><style>")
                .append("body { font-family: Arial, sans-serif; background-color: #f9f9f9; padding: 20px; }")
                .append("h2 { color: #333; text-align: center; }")
                .append("p { font-size: 14px; color: #444; }")
                .append("a { color: blue; text-decoration: none; }")
                .append("table { width: 100%; border-collapse: collapse; background-color: #fff; margin-top: 20px; }")
                .append("th, td { border: 1px solid #ddd; padding: 12px; text-align: center; font-size: 14px; }")
                .append("th { background-color: #f2f2f2; font-weight: bold; }")
                .append(".passed { color: green; font-weight: bold; }")
                .append(".failed { color: red; font-weight: bold; }")
                .append("</style></head><body>")
                .append("<h2>Automation Test Report</h2>")
                .append("<p>Dear Team,</p>")
                .append("<p>Please find the test case summary below:</p>")
                .append("<table>")
                .append("<tr><th>S.No</th><th>Test Case Name</th><th>Status</th></tr>");

        for (Map<String, String> result : testResults) {
            String statusClass = "PASS".equalsIgnoreCase(result.get("Status")) ? "passed" : "failed";
            emailBody.append("<tr>")
                    .append("<td>").append(result.get("S.No")).append("</td>")
                    .append("<td>").append(result.get("Test Case Name")).append("</td>")
                    .append("<td class='").append(statusClass).append("'>").append(result.get("Status")).append("</td>")
                    .append("</tr>");
        }

        emailBody.append("</table>")
                .append("<p>📄 View the full detailed report here: <a href='")
                .append(githubPageUrl)
                .append("' target='_blank'>Click to open report</a></p>")
                .append("<p>Best Regards,<br><strong>Native iOS Team</strong></p>")
                .append("</body></html>");

        email.setHtmlMsg(emailBody.toString());

        // Send email
        email.send();
        System.out.println("========== Native iOS Automation Test Report Sent Successfully ==================");
    }
}