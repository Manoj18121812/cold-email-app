package com.manoj.cold_email_app.service;

import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendMail(String to,
                         String subject,
                         String template) {

        try {

            MimeMessage message =
                    mailSender.createMimeMessage();

            MimeMessageHelper helper =
                    new MimeMessageHelper(message, true);

            helper.setTo(to);
            helper.setSubject(subject);

            String body;

            if ("devops".equals(template)) {

                body = """
Dear Hiring Manager,

I hope this email finds you well. I am writing to express my interest in any open DevOps Engineer or DevOps Intern position at your organization.

I recently completed my DevOps Engineer Internship at iSoftNix Private Limited, 
where I worked on deploying containerized applications on AWS EC2 using Docker and Kubernetes across multiple environments, maintaining 99% uptime. 
I also built Jenkins CI/CD pipelines that cut deployment time from 45 to 18 minutes, and set up Prometheus/Grafana monitoring that helped resolve
 critical performance issues before they impacted production.

Some highlights of my technical background:

• Cloud & Infrastructure: AWS (EC2, S3, IAM, RDS, VPC, Route 53, EKS), Terraform, Ansible
• Containers & Orchestration: Docker, Kubernetes
• CI/CD: Jenkins, Maven, Git/GitHub, Pipeline-as-Code
• DevSecOps: SonarQube, OWASP Dependency-Check, Trivy
• Monitoring: Prometheus, Grafana, Alertmanager

I have also built end-to-end projects covering a two-tier application deployment on Amazon EKS with full CI/CD and monitoring, and a complete DevSecOps pipeline integrating security scanning at every stage of the build process.

Portfolio: https://www.manojkgavhane.co.in

I have attached my resume for your review and would welcome the opportunity to discuss how I can contribute to your team.

Thank you for your time and consideration.

Best Regards,
Manoj Gavhane

+91 8378863043
manojgavhane1812@gmail.com
https://www.manojkgavhane.co.in
https://www.linkedin.com/in/manoj-gavhane-855b4b224
https://github.com/Manoj18121812
""";

            } else {

                body = """
Dear Hiring Manager,

I hope this email finds you well. I am writing to express my interest in any open Cloud Engineer or Cloud Intern position at your organization.

I recently completed my DevOps Engineer Internship at iSoftNix Private Limited, where I worked extensively on AWS cloud infrastructure, deploying and managing containerized applications on EC2 using Docker and Kubernetes across multiple environments while maintaining 99% uptime.

I also configured custom domains, DNS records, SSL/TLS certificates, and Nginx reverse proxies for production web applications, along with setting up Prometheus/Grafana monitoring to proactively catch performance issues before they reached production.

Some highlights of my technical background:

• Cloud & Infrastructure: AWS (EC2, S3, IAM, RDS, VPC, Route 53, EKS), Terraform, Ansible
• Containers & Orchestration: Docker, Kubernetes
• CI/CD: Jenkins, Maven, Git/GitHub, Pipeline-as-Code
• Networking: DNS, TCP/IP, HTTP/HTTPS, Load Balancing, SSL/TLS
• Monitoring: Prometheus, Grafana, Alertmanager

I have also built end-to-end cloud projects, including a production-grade two-tier application deployment on Amazon EKS with auto-scaling, CI/CD automation, and full observability.

Portfolio: https://www.manojkgavhane.co.in

I have attached my resume for your review and would welcome the opportunity to discuss how I can contribute to your team as a Cloud Intern.

Thank you for your time and consideration.

Best Regards,
Manoj Gavhane

+91 8378863043
manojgavhane1812@gmail.com
https://www.manojkgavhane.co.in
https://www.linkedin.com/in/manoj-gavhane-855b4b224
https://github.com/Manoj18121812
""";
            }

            helper.setText(body);

            ClassPathResource file =
                    new ClassPathResource("resume.pdf");

            helper.addAttachment(
                    "Manoj_Gavhane_Resume.pdf",
                    file);

            mailSender.send(message);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}