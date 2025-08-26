package testcases;

import org.kohsuke.github.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.kohsuke.github.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
public class GitHubUploader {
     private final GHRepository repo;
     private final String branch;
     private final String folder;

     public GitHubUploader(String token, String owner, String repoName,
                           String branch, String folder) throws IOException {
         GitHub github = new GitHubBuilder().withOAuthToken(token).build();
         this.repo = github.getRepository(owner + "/" + repoName);
         this.branch = branch;
         this.folder = folder != null && !folder.isBlank()
                 ? folder.replaceAll("^/+|/+$", "") + "/"
                 : "";
         ensureNoJekyll();
     }

     private void ensureNoJekyll() {
         String path = folder + ".nojekyll";
         try {
             repo.getFileContent(path, branch);
         } catch (GHFileNotFoundException nf) {
             try {
                 repo.createContent()
                         .content("")
                         .path(path)
                         .branch(branch)
                         .message("Add .nojekyll to disable Jekyll processing")
                         .commit();
             } catch (IOException ignore) {}
         } catch (IOException ignore) {}
     }

     public String upload(File localHtml) throws IOException {
         // 🔹 Replace '#' and spaces with safe characters
         String safeName = localHtml.getName().replace("#", "_").replace(" ", "_");
         File safeFile = localHtml;

         // If file has changed name, create a renamed copy
         if (!safeName.equals(localHtml.getName())) {
             safeFile = new File(localHtml.getParent(), safeName);
             Files.copy(localHtml.toPath(), safeFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
         }

         String targetPath = folder + safeFile.getName();
         String commitMsg = "Report: " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
         byte[] contentBytes = Files.readAllBytes(safeFile.toPath());

         try {
             GHContent existing = repo.getFileContent(targetPath, branch);
             existing.update(contentBytes, commitMsg, branch);
         } catch (GHFileNotFoundException e) {
             repo.createContent()
                     .content(contentBytes)
                     .path(targetPath)
                     .branch(branch)
                     .message(commitMsg)
                     .commit();
         }

         // ✅ Ensure lowercase repo/owner + remove "docs/" if present
         String owner = repo.getOwnerName().toLowerCase();
         String name = repo.getName().toLowerCase();
         String publicPath = targetPath.replaceFirst("^docs/", "");

         return String.format("https://%s.github.io/%s/%s", owner, name, publicPath);
     }
 }
