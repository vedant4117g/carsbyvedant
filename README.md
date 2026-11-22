## ☁️ Production-Grade AWS & Docker Multi-Tier Architecture

This project (`vedant4117g/carsbyvedant`) is containerized with **Docker & Docker Compose** and deployed on a highly available, security-hardened **AWS Multi-Tier VPC Architecture**.

![AWS Production Architecture](screenshots/architecture-diagram.png)

### 🏗️ Architecture Highlights

* **Custom VPC & Multi-AZ Networking (`ap-south-1`):**
  * **2 Public Subnets:** Host the Internet-facing Application Load Balancer (ALB), Bastion Host (Jump Server), and NAT Gateway.
  * **2 Private Subnets:** Host the Auto Scaling Group (ASG) running the application and database containers with **zero Public IP exposure**.
  * **NAT Gateway & Route Tables:** Provides controlled outbound internet access to private instances for pulling Docker images and OS security patches without allowing inbound internet connections.

* **Defense-in-Depth Security:**
  * **Security Group Chaining:** Application instances only accept HTTP traffic from the ALB Security Group and SSH (`Port 22`) strictly from the Bastion Host Security Group (`0.0.0.0/0` SSH is completely blocked).
  * **Bastion Host Access:** Administrative access to private instances is routed exclusively through the Bastion Host using `ssh -i key.pem`.
  * **End-to-End HTTPS:** Managed custom domain routing (`carsbyvedant.in`) via **AWS Route 53** secured with TLS/SSL certificates from **AWS Certificate Manager (ACM)**.

* **Containerized Application Stack:**
  * **Backend:** Java 21 & Spring Boot containerized and published to Docker Hub (`vedant4117g/carsbyvedant:latest`).
  * **Database:** MariaDB running in an isolated Docker bridge network with persistent volume storage orchestrated via `docker-compose.yml`.
  * **Auto Scaling:** Launch Template (v2) automates container initialization and health-checked scaling behind the ALB Target Group.

---

### 🛠️ Tech Stack & Cloud Services

| Layer | Technologies / Services Used |
| :--- | :--- |
| **Application & DB** | Java 21, Spring Boot, MariaDB, HTML/JS |
| **Containerization** | Docker, Docker Compose, Docker Hub (`vedant4117g`) |
| **Networking & Security** | AWS VPC, Public/Private Subnets, IGW, NAT Gateway, Security Groups, Bastion Host |
| **Compute & Scaling** | Amazon EC2 (Ubuntu), Launch Templates, Auto Scaling Groups (ASG) |
| **Traffic & DNS** | Application Load Balancer (ALB), Target Groups, Route 53, AWS ACM (SSL/TLS) |

---

### 🔐 Secure SSH Access Workflow (Bastion Jump)

```bash
# 1. Set strict read-only permissions on the private key
chmod 400 key.pem

# 2. Connect to the Bastion Host in the Public Subnet
ssh -i key.pem ubuntu@<BASTION_PUBLIC_IP>

# 3. Jump from the Bastion Host to the EC2 instance in the Private Subnet
ssh -i key.pem ubuntu@<PRIVATE_EC2_IP>

# 4. Verify running Docker containers
sudo docker ps
