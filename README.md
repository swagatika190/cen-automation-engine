# 🔄 CEN Automation Engine - Workflow Automation Platform

A powerful enterprise-grade backend system for automating business workflows and processes through a node-based architecture with asynchronous message-driven execution. This engine enables users to create, manage, and execute complex workflows with RabbitMQ integration for scalable, distributed processing.

![Java](https://img.shields.io/badge/Java-ED8B00?style=flat-square&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-6DB33F?style=flat-square&logo=spring-boot&logoColor=white)
![RabbitMQ](https://img.shields.io/badge/RabbitMQ-FF6600?style=flat-square&logo=rabbitmq&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-4479A1?style=flat-square&logo=mysql&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-C71A36?style=flat-square&logo=apache-maven&logoColor=white)

---

## 📋 Table of Contents
- [Overview](#-overview)
- [Features](#-features)
- [Tech Stack](#-tech-stack)
- [System Architecture](#-system-architecture)
- [RabbitMQ Integration](#-rabbitmq-integration)
- [Database Schema](#-database-schema)
- [API Endpoints](#-api-endpoints)
- [Installation & Setup](#-installation--setup)
- [Usage Examples](#-usage-examples)
- [Project Structure](#-project-structure)
- [What I Learned](#-what-i-learned)
- [Future Enhancements](#-future-enhancements)
- [Contact](#-contact)

---

## 🎯 Overview

The **CEN Automation Engine** is an enterprise-grade workflow automation platform that combines **node-based workflow orchestration** with **asynchronous message-driven architecture** using RabbitMQ. This system allows organizations to automate complex business processes with scalability, reliability, and distributed execution capabilities.

### Key Highlights
- **Asynchronous Execution** - Non-blocking workflow processing using RabbitMQ message queues
- **Scalable Architecture** - Distributed processing with multiple worker nodes
- **Node-Based Workflows** - Visual workflow creation through configurable nodes
- **Real-time Monitoring** - Track workflow execution status and logs
- **Reliable Processing** - Message persistence and automatic retry mechanisms

### Use Cases
- **Business Process Automation** - Automate approval workflows, order processing, data pipelines
- **Event-Driven Systems** - Trigger workflows based on business events
- **Integration Hub** - Connect different systems through workflow orchestration
- **Batch Processing** - Schedule and execute large-scale data processing tasks
- **Microservices Orchestration** - Coordinate operations across multiple microservices

---

## ✨ Features

### Workflow Management
- 🔧 **Create Workflows** - Define custom workflows with multiple interconnected nodes
- 📝 **Update Workflows** - Modify existing workflow configurations dynamically
- 🗑️ **Delete Workflows** - Remove obsolete workflows with cascade deletion
- 📊 **View Workflows** - List all workflows or retrieve specific workflow details
- ▶️ **Execute Workflows** - Trigger workflow execution manually or programmatically
- 🔄 **Workflow Versioning** - Track workflow changes over time

### Node-Based Architecture
- 🔗 **Node Configuration** - Define individual task nodes with specific actions
- 🔀 **Node Chaining** - Connect multiple nodes in sequential or parallel execution
- ⚙️ **Node Parameters** - Configure node-specific settings, inputs, and outputs
- 📍 **Node Status Tracking** - Monitor individual node execution status in real-time
- 🎯 **Node Types** - Support for various node types (START, PROCESS, DECISION, END)

### RabbitMQ Integration
- 📨 **Message Queue Processing** - Asynchronous workflow execution through RabbitMQ
- 🔄 **Message Persistence** - Durable messages ensure no data loss
- 📬 **Queue Management** - Dedicated queues for different workflow types
- 🔁 **Dead Letter Queues** - Handle failed messages with DLQ pattern
- ⚡ **Scalable Workers** - Multiple consumer instances for parallel processing
- 📊 **Queue Monitoring** - Track message counts and processing rates

### Transaction Management
- 💾 **Transaction Recording** - Track every workflow execution with unique IDs
- 📈 **Execution Status** - Monitor workflow progress (PENDING, RUNNING, COMPLETED, FAILED)
- ⏱️ **Execution Time Tracking** - Record start time, end time, and duration
- 🔄 **Automatic Retry** - Retry failed workflows with exponential backoff
- 📊 **Transaction History** - Complete audit trail of all executions
- 🎯 **Idempotency** - Prevent duplicate processing of the same workflow

### Logging & Monitoring
- 📋 **Multi-Level Logging** - Logs at workflow, transaction, and node levels
- 🐛 **Error Tracking** - Capture and store detailed error messages and stack traces
- 📉 **Performance Metrics** - Track execution times, queue depths, and throughput
- 🔍 **Audit Trail** - Complete audit trail for compliance and debugging
- 📊 **Real-time Dashboards** - Monitor active workflows and queue status

### Advanced Features
- 🎭 **Context Management** - Share data between workflow nodes during execution
- 🔄 **Data Conversion** - Transform data between different formats
- 🎧 **Event Listeners** - React to workflow lifecycle events
- ⚠️ **Exception Handling** - Graceful error handling with custom exceptions
- 🛠️ **Utility Functions** - Common helper functions for workflow operations
- 🔐 **Configuration Management** - Externalized configuration for different environments

---

## 🛠️ Tech Stack

### Backend Framework
- **Java 8+** - Core programming language
- **Spring Boot 2.x** - Application framework
- **Spring MVC** - RESTful API framework
- **Spring Data JPA** - Database access and ORM
- **Spring AMQP** - RabbitMQ integration for Spring
- **Hibernate** - Object-Relational Mapping

### Message Queue
- **RabbitMQ 3.x** - Message broker for asynchronous processing
  - Publisher-Subscriber pattern for workflow events
  - Work Queues for distributed task processing
  - Dead Letter Exchanges for failed message handling
  - Message persistence for reliability
  - Acknowledgment mechanisms for guaranteed delivery

### Database
- **MySQL 8.0** - Relational database for persistent storage
  - Stores workflow definitions, nodes, transactions
  - Optimized with indexes for performance
  - ACID compliance for data integrity

### Build & Dependencies
- **Maven 3.6+** - Build automation and dependency management
- **Lombok** - Reduce boilerplate code
- **Jackson** - JSON serialization/deserialization
- **SLF4J + Logback** - Logging framework

### Architecture Patterns
- **Event-Driven Architecture** - Asynchronous processing with RabbitMQ
- **MVC Pattern** - Model-View-Controller for REST APIs
- **Repository Pattern** - Data access abstraction
- **DTO Pattern** - Data Transfer Objects for API communication
- **Factory Pattern** - Dynamic node creation
- **Observer Pattern** - Event listeners for workflow events
- **Producer-Consumer Pattern** - Message queue processing

### Tools
- **Postman** - API testing and documentation
- **RabbitMQ Management Console** - Queue monitoring and management
- **MySQL Workbench** - Database design and management
- **Git & GitHub** - Version control
- **IntelliJ IDEA / Eclipse** - IDE

---

## 🏗️ System Architecture

### High-Level Architecture

```
┌─────────────────────────────────────────────────────────────┐
│                  Client / External System                    │
│              (REST API Calls / Scheduled Jobs)              │
└───────────────────────┬─────────────────────────────────────┘
                        │ HTTP Requests
                        ▼
┌─────────────────────────────────────────────────────────────┐
│                   Controller Layer                           │
│     (WorkflowController, NodeController, etc.)              │
│     - Receive HTTP requests                                 │
│     - Validate inputs                                       │
│     - Publish workflow execution messages to RabbitMQ       │
└───────────────────────┬─────────────────────────────────────┘
                        │
                        ▼
┌─────────────────────────────────────────────────────────────┐
│                    Service Layer                             │
│  (WorkflowService, NodeService, TransactionService)         │
│  - Business logic implementation                            │
│  - Publish messages to RabbitMQ queues                      │
│  - Transaction management                                   │
└───────────────────────┬─────────────────────────────────────┘
                        │
                        ▼
        ┌───────────────────────────────────┐
        │         RabbitMQ Broker           │
        ├───────────────────────────────────┤
        │  Exchanges:                       │
        │  - workflow.exchange              │
        │  - dlx.exchange (Dead Letter)     │
        │                                   │
        │  Queues:                          │
        │  - workflow.execution.queue       │
        │  - workflow.retry.queue           │
        │  - workflow.dlq (Dead Letter)     │
        └───────────────┬───────────────────┘
                        │
                        ▼
┌─────────────────────────────────────────────────────────────┐
│              Message Listener (Consumer)                     │
│  - @RabbitListener on workflow queues                       │
│  - Consume workflow execution messages                      │
│  - Trigger workflow engine                                  │
└───────────────────────┬─────────────────────────────────────┘
                        │
                        ▼
┌─────────────────────────────────────────────────────────────┐
│                 Workflow Engine Core                         │
│  - Parse workflow definition from database                  │
│  - Execute nodes sequentially/parallel                      │
│  - Manage context between nodes                             │
│  - Handle exceptions and retries                            │
│  - Trigger event listeners                                  │
│  - Update transaction status                                │
└───────────────────────┬─────────────────────────────────────┘
                        │
                        ▼
┌─────────────────────────────────────────────────────────────┐
│                  Repository Layer                            │
│  (WorkflowRepository, NodeRepository,                       │
│   TransactionRepository, LogRepository)                     │
│  - CRUD operations                                          │
│  - Custom JPA queries                                       │
└───────────────────────┬─────────────────────────────────────┘
                        │
                        ▼
┌─────────────────────────────────────────────────────────────┐
│                   Database (MySQL)                           │
│  - Workflows, Nodes, Transactions, Logs                     │
└─────────────────────────────────────────────────────────────┘
```

---

## 🐰 RabbitMQ Integration

### Message Flow Architecture

```
┌──────────────┐         ┌─────────────────┐         ┌──────────────┐
│   Producer   │────────>│  RabbitMQ       │────────>│   Consumer   │
│ (Controller/ │ Publish │  Exchange       │ Route   │  (Listener)  │
│   Service)   │ Message │  + Queue        │ Message │              │
└──────────────┘         └─────────────────┘         └──────────────┘
                                 │
                                 │ Failed Messages
                                 ▼
                         ┌─────────────────┐
                         │ Dead Letter     │
                         │ Exchange + Queue│
                         └─────────────────┘
```

### Queue Configuration

**1. Workflow Execution Queue**
```java
Queue: workflow.execution.queue
- Durable: true (survives broker restart)
- Auto-delete: false
- Arguments: 
  - x-dead-letter-exchange: dlx.exchange
  - x-message-ttl: 3600000 (1 hour)
```

**2. Retry Queue**
```java
Queue: workflow.retry.queue
- For workflows that need to be retried
- Messages republished after delay
```

**3. Dead Letter Queue (DLQ)**
```java
Queue: workflow.dlq
- Stores messages that failed after max retries
- Manual intervention required
```

### Exchange Configuration

**1. Direct Exchange**
```java
Exchange: workflow.exchange
Type: direct
Routing Keys:
  - workflow.execute
  - workflow.retry
```

**2. Dead Letter Exchange**
```java
Exchange: dlx.exchange
Type: fanout
Routes to: workflow.dlq
```

### Message Structure

**Workflow Execution Message:**
```json
{
  "workflowId": 123,
  "transactionId": 456,
  "inputData": {
    "key1": "value1",
    "key2": "value2"
  },
  "priority": "HIGH",
  "retryCount": 0,
  "timestamp": "2024-11-15T10:30:00Z"
}
```

### Benefits of RabbitMQ Integration

✅ **Asynchronous Processing** - Non-blocking workflow execution  
✅ **Scalability** - Multiple consumers process workflows in parallel  
✅ **Reliability** - Message persistence ensures no data loss  
✅ **Fault Tolerance** - Automatic retry with dead letter queues  
✅ **Decoupling** - Loose coupling between API and execution engine  
✅ **Load Balancing** - Distribute workload across multiple workers  
✅ **Priority Processing** - Handle urgent workflows first  

---

## 💾 Database Schema

### Entity Relationship Diagram

```
┌─────────────────┐
│  WorkflowModel  │
├─────────────────┤
│ workflow_id(PK) │
│ workflow_name   │
│ description     │
│ is_active       │
│ created_at      │
│ updated_at      │
└────────┬────────┘
         │
         │ 1:N (One Workflow has Many Nodes)
         │
         ▼
┌──────────────────┐
│ NodeDetailsModel │
├──────────────────┤
│ node_id (PK)     │
│ workflow_id (FK) │
│ node_name        │
│ node_type        │
│ node_order       │
│ configuration    │
│ is_active        │
└────────┬─────────┘
         │
         │
         │
┌────────▼─────────────────┐
│  WorkflowModel           │
│        │                 │
│        │ 1:N (One Workflow has Many Transactions)
│        ▼                 │
│ ┌──────────────────────┐│
│ │ WorkflowTransaction  ││
│ ├──────────────────────┤│
│ │ transaction_id (PK)  ││
│ │ workflow_id (FK)     ││
│ │ status               ││
│ │ start_time           ││
│ │ end_time             ││
│ │ execution_result     ││
│ │ message_id           ││
│ │ queue_name           ││
│ └──────────┬───────────┘│
│            │             │
│            │ 1:N (One Transaction has Many Logs)
│            ▼             │
│ ┌──────────────────────┐│
│ │WorkflowTransaction   ││
│ │LogModel              ││
│ ├──────────────────────┤│
│ │ log_id (PK)          ││
│ │ transaction_id (FK)  ││
│ │ node_id (FK)         ││
│ │ log_message          ││
│ │ log_level            ││
│ │ timestamp            ││
│ │ error_details        ││
│ └──────────────────────┘│
└──────────────────────────┘
```

### Key Tables

**Workflows Table:**
```sql
CREATE TABLE workflows (
    workflow_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    workflow_name VARCHAR(255) NOT NULL UNIQUE,
    description TEXT,
    is_active BOOLEAN DEFAULT TRUE,
    created_by VARCHAR(100),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);
```

**Node Details Table:**
```sql
CREATE TABLE node_details (
    node_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    workflow_id BIGINT NOT NULL,
    node_name VARCHAR(255) NOT NULL,
    node_type VARCHAR(100) NOT NULL, -- START, PROCESS, DECISION, END
    node_order INT NOT NULL,
    configuration JSON, -- Node-specific config
    input_params JSON,
    output_params JSON,
    is_active BOOLEAN DEFAULT TRUE,
    FOREIGN KEY (workflow_id) REFERENCES workflows(workflow_id) ON DELETE CASCADE,
    INDEX idx_workflow_order (workflow_id, node_order)
);
```

**Workflow Transactions Table:**
```sql
CREATE TABLE workflow_transactions (
    transaction_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    workflow_id BIGINT NOT NULL,
    status VARCHAR(50) NOT NULL, -- PENDING, RUNNING, COMPLETED, FAILED
    start_time TIMESTAMP,
    end_time TIMESTAMP,
    execution_result TEXT,
    triggered_by VARCHAR(100),
    error_message TEXT,
    message_id VARCHAR(255), -- RabbitMQ message ID
    queue_name VARCHAR(255), -- Queue name for tracking
    retry_count INT DEFAULT 0,
    FOREIGN KEY (workflow_id) REFERENCES workflows(workflow_id),
    INDEX idx_status (status),
    INDEX idx_message_id (message_id)
);
```

**Transaction Logs Table:**
```sql
CREATE TABLE workflow_transaction_logs (
    log_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    transaction_id BIGINT NOT NULL,
    node_id BIGINT,
    log_message TEXT NOT NULL,
    log_level VARCHAR(20), -- INFO, DEBUG, WARN, ERROR
    timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    error_details TEXT,
    FOREIGN KEY (transaction_id) REFERENCES workflow_transactions(transaction_id) ON DELETE CASCADE,
    FOREIGN KEY (node_id) REFERENCES node_details(node_id),
    INDEX idx_transaction (transaction_id),
    INDEX idx_timestamp (timestamp)
);
```

---

## 🔌 API Endpoints

### Workflow Management APIs

| Method | Endpoint | Description | Request Body |
|--------|----------|-------------|--------------|
| POST | `/api/workflows` | Create new workflow | `{ name, description, isActive }` |
| GET | `/api/workflows` | Get all workflows | - |
| GET | `/api/workflows/{id}` | Get workflow by ID | - |
| PUT | `/api/workflows/{id}` | Update workflow | `{ name, description, isActive }` |
| DELETE | `/api/workflows/{id}` | Delete workflow | - |
| POST | `/api/workflows/{id}/execute` | Publish workflow to queue | `{ inputData }` |
| GET | `/api/workflows/{id}/status` | Get execution status | - |

### Node Management APIs

| Method | Endpoint | Description | Request Body |
|--------|----------|-------------|--------------|
| POST | `/api/nodes` | Create workflow node | `{ workflowId, nodeName, nodeType, order, config }` |
| GET | `/api/nodes/workflow/{workflowId}` | Get all nodes for workflow | - |
| GET | `/api/nodes/{id}` | Get node by ID | - |
| PUT | `/api/nodes/{id}` | Update node | `{ nodeName, nodeType, config }` |
| DELETE | `/api/nodes/{id}` | Delete node | - |

### Transaction APIs

| Method | Endpoint | Description | Request Body |
|--------|----------|-------------|--------------|
| GET | `/api/transactions` | Get all transactions | - |
| GET | `/api/transactions/{id}` | Get transaction details | - |
| GET | `/api/transactions/workflow/{workflowId}` | Get transactions for workflow | - |
| GET | `/api/transactions/{id}/logs` | Get transaction logs | - |
| PUT | `/api/transactions/{id}/retry` | Republish to retry queue | - |
| GET | `/api/transactions/status/{status}` | Get transactions by status | - |

### Queue Management APIs

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/api/queue/stats` | Get queue statistics |
| GET | `/api/queue/pending` | Count pending messages |
| POST | `/api/queue/purge/{queueName}` | Purge queue messages |

---

## 🚀 Installation & Setup

### Prerequisites
- **Java 8 or higher** installed
- **MySQL 8.0** installed and running
- **RabbitMQ 3.x** installed and running
- **Maven 3.6+** installed
- **Git** installed

### Step 1: Install RabbitMQ

**On Ubuntu/Debian:**
```bash
sudo apt-get update
sudo apt-get install rabbitmq-server
sudo systemctl enable rabbitmq-server
sudo systemctl start rabbitmq-server

# Enable RabbitMQ Management Plugin
sudo rabbitmq-plugins enable rabbitmq_management

# Access Management UI at: http://localhost:15672
# Default credentials: guest / guest
```

**On Windows:**
1. Download RabbitMQ installer from https://www.rabbitmq.com/download.html
2. Install RabbitMQ
3. Install Erlang (dependency)
4. Start RabbitMQ service
5. Access Management Console: http://localhost:15672

**On macOS:**
```bash
brew install rabbitmq
brew services start rabbitmq
```

### Step 2: Configure RabbitMQ

Create queues and exchanges:
```bash
# Login to RabbitMQ Management Console
# Or use rabbitmqadmin CLI

# Create exchange
rabbitmqadmin declare exchange name=workflow.exchange type=direct durable=true

# Create queues
rabbitmqadmin declare queue name=workflow.execution.queue durable=true
rabbitmqadmin declare queue name=workflow.retry.queue durable=true
rabbitmqadmin declare queue name=workflow.dlq durable=true

# Create bindings
rabbitmqadmin declare binding source=workflow.exchange destination=workflow.execution.queue routing_key=workflow.execute
```

### Step 3: Clone the Repository
```bash
git clone https://github.com/swagatika190/cen-automation-engine.git
cd cen-automation-engine
```

### Step 4: Configure MySQL Database
```bash
# Login to MySQL
mysql -u root -p

# Create database
CREATE DATABASE workflow_automation;
exit;
```

### Step 5: Update Application Properties

Edit `src/main/resources/application.properties`:

```properties
# Server Configuration
server.port=8080

# Database Configuration
spring.datasource.url=jdbc:mysql://localhost:3306/workflow_automation
spring.datasource.username=your_mysql_username
spring.datasource.password=your_mysql_password
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

# JPA Configuration
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
spring.jpa.properties.hibernate.format_sql=true

# RabbitMQ Configuration
spring.rabbitmq.host=localhost
spring.rabbitmq.port=5672
spring.rabbitmq.username=guest
spring.rabbitmq.password=guest
spring.rabbitmq.virtual-host=/

# RabbitMQ Queue Names
workflow.queue.execution=workflow.execution.queue
workflow.queue.retry=workflow.retry.queue
workflow.queue.dlq=workflow.dlq
workflow.exchange.name=workflow.exchange
workflow.routing.key.execute=workflow.execute

# RabbitMQ Listener Configuration
spring.rabbitmq.listener.simple.acknowledge-mode=manual
spring.rabbitmq.listener.simple.prefetch=10
spring.rabbitmq.listener.simple.retry.enabled=true
spring.rabbitmq.listener.simple.retry.max-attempts=3

# Logging
logging.level.com.jsp.cemautomationengine=DEBUG
logging.level.org.springframework.amqp=DEBUG
logging.pattern.console=%d{yyyy-MM-dd HH:mm:ss} - %msg%n
```

### Step 6: Build the Project
```bash
mvn clean install
```

### Step 7: Run the Application
```bash
mvn spring-boot:run
```

The application will start on:
```
http://localhost:8080
```

RabbitMQ Management Console:
```
http://localhost:15672
```

---

## 💡 Usage Examples

### Example 1: Creating and Executing a Workflow

**Step 1: Create a Workflow**
```bash
POST http://localhost:8080/api/workflows
Content-Type: application/json

{
    "workflow_name": "Email Notification Workflow",
    "description": "Sends email notifications to users",
    "is_active": true
}
```

**Step 2: Add Nodes**
```bash
POST http://localhost:8080/api/nodes
Content-Type: application/json

{
    "workflow_id": 1,
    "node_name": "Fetch User Data",
    "node_type": "DATABASE_QUERY",
    "node_order": 1,
    "configuration": {
        "query": "SELECT * FROM users WHERE active=true"
    }
}

POST http://localhost:8080/api/nodes
Content-Type: application/json

{
    "workflow_id": 1,
    "node_name": "Send Email",
    "node_type": "EMAIL_SENDER",
    "node_order": 2,
    "configuration": {
        "template": "welcome_email",
        "subject": "Welcome!"
    }
}
```

**Step 3: Execute Workflow (Publishes to RabbitMQ)**
```bash
POST http://localhost:8080/api/workflows/1/execute
Content-Type: application/json

{
    "inputData": {
        "userId": 123,
        "emailType": "welcome"
    }
}
```

**Response:**
```json
{
    "status": 202,
    "message": "Workflow execution request published to queue",
    "data": {
        "transaction_id": 456,
        "message_id": "msg-12345-abc",
        "queue_name": "workflow.execution.queue",
        "status": "PENDING"
    }
}
```

**Step 4: Check Execution Status**
```bash
GET http://localhost:8080/api/transactions/456
```

**Response:**
```json
{
    "transaction_id": 456,
    "workflow_id": 1,
    "status": "COMPLETED",
    "start_time": "2024-11-15T10:30:00",
    "end_time": "2024-11-15T10:30:05",
    "execution_result": "Success",
    "message_id": "msg-12345-abc"
}
```

### Example 2: Monitoring RabbitMQ Queues

**Check Queue Stats:**
```bash
GET http://localhost:8080/api/queue/stats
```

**Response:**
```json
{
    "workflow.execution.queue": {
        "messages": 5,
        "consumers": 2,
        "message_rate": 10.5
    },
    "workflow.retry.queue": {
        "messages": 0,
        "consumers": 1,
        "message_rate": 0.0
    },
    "workflow.dlq": {
        "messages": 2,
        "consumers": 0,
        "message_rate": 0.0
    }
}
```

---

## 📁 Project Structure

```
cen-automation-engine/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/jsp/cemautomationengine/
│   │   │       │
│   │   │       ├── config/              # Configuration classes
│   │   │       │   ├── RabbitMQConfig.java
│   │   │       │   └── ApplicationConfig.java
│   │   │       │
│   │   │       ├── constant/            # Application constants
│   │   │       │   ├── WorkflowConstants.java
│   │   │       │   └── QueueConstants.java
│   │   │       │
│   │   │       ├── context/             # Workflow execution context
│   │   │       │   └── WorkflowContext.java
│   │   │       │
│   │   │       ├── controller/          # REST Controllers
│   │   │       │   ├── WorkflowController.java
│   │   │       │   ├── NodeController.java
│   │   │       │   ├── TransactionController.java
│   │   │       │   └── QueueController.java
│   │   │       │
│   │   │       ├── converter/           # Data converters
│   │   │       │   └── DataConverter.java
│   │   │       │
│   │   │       ├── dto/                 # Data Transfer Objects
│   │   │       │   ├── WorkflowDTO.java
│   │   │       │   ├── NodeDTO.java
│   │   │       │   ├── WorkflowExecutionMessage.java
│   │   │       │   └── ResponseDTO.java
│   │   │       │
│   │   │       ├── entity/              # Database Entities
│   │   │       │   ├── EntityModel.java
│   │   │       │   ├── WorkflowModel.java
│   │   │       │   ├── NodeDetailsModel.java
│   │   │       │   ├── WorkflowTransaction.java
│   │   │       │   └── WorkflowTransactionLogModel.java
│   │   │       │
│   │   │       ├── exception/           # Custom Exceptions
│   │   │       │   ├── WorkflowNotFoundException.java
│   │   │       │   ├── NodeExecutionException.java
│   │   │       │   ├── MessageProcessingException.java
│   │   │       │   └── GlobalExceptionHandler.java
│   │   │       │
│   │   │       ├── listener/            # RabbitMQ Listeners
│   │   │       │   ├── WorkflowExecutionListener.java
│   │   │       │   ├── WorkflowRetryListener.java
│   │   │       │   └── WorkflowEventListener.java
│   │   │       │
│   │   │       ├── repository/          # JPA Repositories
│   │   │       │   ├── WorkflowRepository.java
│   │   │       │   ├── NodeRepository.java
│   │   │       │   ├── TransactionRepository.java
│   │   │       │   └── LogRepository.java
│   │   │       │
│   │   │       ├── result/              # Result handling
│   │   │       │   └── ExecutionResult.java
│   │   │       │
│   │   │       ├── service/             # Business Logic
│   │   │       │   ├── WorkflowService.java
│   │   │       │   ├── NodeExecutionService.java
│   │   │       │   ├── TransactionService.java
│   │   │       │   ├── MessagePublisherService.java
│   │   │       │   └── QueueManagementService.java
│   │   │       │
│   │   │       ├── util/                # Utility classes
│   │   │       │   └── WorkflowUtils.java
│   │   │       │
│   │   │       └── CenAutomationEngineApplication.java
│   │   │
│   │   └── resources/
│   │       ├── application.properties
│   │       └── application-dev.properties
│   │
│   └── test/
│       └── java/
│           └── com/jsp/cemautomationengine/
│               ├── WorkflowServiceTest.java
│               └── MessageListenerTest.java
│
├── pom.xml
└── README.md
```

---

## 📚 What I Learned

Building this workflow automation engine with RabbitMQ integration provided deep insights into:

✅ **Message-Driven Architecture:**
- Implementing asynchronous processing with RabbitMQ
- Designing message flows with exchanges, queues, and routing keys
- Understanding publisher-subscriber and work queue patterns
- Implementing dead letter queues for failed message handling
- Managing message acknowledgments and manual confirmations
- Configuring message persistence for reliability

✅ **Distributed Systems:**
- Building scalable systems with message queues
- Handling distributed transactions and eventual consistency
- Implementing retry mechanisms with exponential backoff
- Managing concurrent processing with multiple consumers
- Load balancing across worker nodes

✅ **Spring AMQP Integration:**
- Using @RabbitListener for message consumption
- Configuring RabbitTemplate for message publishing
- Setting up connection factories and message converters
- Implementing error handlers for failed messages
- Managing listener containers and prefetch counts

✅ **Complex System Design:**
- Designing node-based execution engines
- Managing workflow state and context
- Implementing transaction management for reliability
- Building event-driven architectures
- Decoupling API layer from processing layer

✅ **Advanced Spring Boot:**
- Complex entity relationships with JPA
- Implementing custom repositories with complex queries
- Using Spring's event listener mechanism
- Configuration management for different environments
- Integration testing with embedded message brokers

✅ **Database Design:**
- Designing schemas for hierarchical data (workflows → nodes → transactions → logs)
- Implementing cascading deletes and referential integrity
- JSON column types for flexible configuration storage
- Indexing strategies for performance optimization
- Tracking message IDs for idempotency

✅ **Error Handling & Monitoring:**
- Comprehensive exception handling strategy
- Multi-level logging (workflow, transaction, node level)
- Dead letter queue management
- Audit trail implementation
- Retry mechanisms for transient failures

✅ **Performance Optimization:**
- Message prefetch optimization for throughput
- Database connection pooling
- Asynchronous processing for better scalability
- Queue monitoring and alerting

---

## 🔮 Future Enhancements

### Message Queue Features
- [ ] **Priority Queues** - Implement priority-based message processing
- [ ] **Message Scheduling** - Delayed message delivery for scheduled workflows
- [ ] **Kafka Integration** - Add Apache Kafka as alternative message broker
- [ ] **Message Routing** - Dynamic routing based on workflow type
- [ ] **Circuit Breaker** - Implement circuit breaker pattern for external services

### Core Workflow Features
- [ ] **Parallel Execution** - Execute independent nodes in parallel
- [ ] **Conditional Branching** - Add decision nodes for conditional paths
- [ ] **Loop Support** - Implement loop nodes for iterative operations
- [ ] **Sub-workflows** - Support for nested workflows
- [ ] **Workflow Templates** - Pre-built templates for common use cases
- [ ] **Dynamic Node Loading** - Load node implementations dynamically

### Integration & Connectivity
- [ ] **REST API Nodes** - Call external REST APIs from workflows
- [ ] **Database Connector Nodes** - Direct database operations (CRUD)
- [ ] **Email/SMS Nodes** - Send notifications from workflows
- [ ] **File Processing Nodes** - Read/Write files (CSV, JSON, XML)
- [ ] **Webhook Support** - Trigger workflows via webhooks
- [ ] **FTP/SFTP Nodes** - File transfer operations

### Monitoring & Management
- [ ] **Real-time Dashboard** - React/Angular dashboard for monitoring
- [ ] **Performance Analytics** - Execution time analysis and bottleneck detection
- [ ] **Alert System** - Email/SMS alerts for workflow failures
- [ ] **Workflow Versioning** - Version control for workflow definitions
- [ ] **Rollback Mechanism** - Revert to previous workflow versions
- [ ] **Queue Health Monitoring** - Monitor queue depths and consumer health

### Advanced Features
- [ ] **Workflow Scheduler** - Cron-based workflow scheduling
- [ ] **Priority Queue** - Prioritize workflow executions
- [ ] **Resource Management** - Limit concurrent executions
- [ ] **Data Validation Nodes** - Built-in validation capabilities
- [ ] **ML Integration** - Machine learning model execution nodes
- [ ] **GraphQL API** - Add GraphQL support alongside REST

### Security & Compliance
- [ ] **JWT Authentication** - Secure API endpoints
- [ ] **Role-Based Access Control** - User permissions for workflows
- [ ] **Message Encryption** - Encrypt sensitive workflow data in messages
- [ ] **Compliance Logging** - Enhanced audit trails for regulatory compliance
- [ ] **OAuth2 Integration** - OAuth2 authentication for external services

### Deployment & Scalability
- [ ] **Docker Support** - Containerize the application
- [ ] **Kubernetes Deployment** - Deploy on Kubernetes clusters
- [ ] **Horizontal Scaling** - Support for multiple engine instances
- [ ] **Redis Caching** - Cache workflow definitions and node configurations
- [ ] **Cloud Deployment** - Deploy on AWS/Azure/GCP with managed RabbitMQ
- [ ] **Auto-scaling** - Automatic scaling based on queue depth

### Developer Experience
- [ ] **Workflow Builder UI** - Drag-and-drop workflow designer
- [ ] **API Documentation** - Swagger/OpenAPI documentation
- [ ] **SDK/Client Libraries** - Java, Python, Node.js client libraries
- [ ] **CLI Tool** - Command-line interface for workflow management
- [ ] **Postman Collection** - Complete API collection with examples

---

## 🧪 Testing

### Manual Testing with Postman

Import the Postman collection and test:

1. **Workflow CRUD Operations**
2. **Node Configuration**
3. **Workflow Execution (Message Publishing)**
4. **Queue Monitoring**
5. **Transaction Status Tracking**
6. **Log Retrieval**

### RabbitMQ Monitoring

**Check Queue Status:**
1. Open RabbitMQ Management Console: http://localhost:15672
2. Navigate to "Queues" tab
3. Monitor:
   - Message counts
   - Consumer counts
   - Message rates
   - Dead letter queue contents

### Test Scenarios

**Scenario 1: Successful Workflow Execution**
```
1. Create workflow with 3 nodes
2. Execute workflow
3. Verify message published to queue
4. Check transaction status changes: PENDING → RUNNING → COMPLETED
5. Verify logs generated for each node
```

**Scenario 2: Failed Workflow with Retry**
```
1. Create workflow with intentional failure
2. Execute workflow
3. Verify message moved to retry queue
4. Check retry attempts in transaction
5. Verify final status after max retries
```

**Scenario 3: Dead Letter Queue**
```
1. Create workflow that fails all retries
2. Execute workflow
3. Verify message ends up in DLQ
4. Manual inspection of failed message
```

---

## 🔧 Troubleshooting

### Common Issues

**Issue 1: RabbitMQ Connection Failed**
```
Error: Could not connect to RabbitMQ on localhost:5672

Solution:
1. Check if RabbitMQ is running: sudo systemctl status rabbitmq-server
2. Verify connection settings in application.properties
3. Check firewall settings
```

**Issue 2: Messages Not Being Consumed**
```
Symptom: Messages accumulate in queue, no processing

Solution:
1. Check listener configuration in code
2. Verify consumer is running
3. Check for exceptions in application logs
4. Verify queue bindings are correct
```

**Issue 3: Dead Letter Queue Growing**
```
Symptom: Many messages in DLQ

Solution:
1. Check error logs for failure reasons
2. Fix underlying issue in workflow nodes
3. Requeue messages for reprocessing
4. Adjust retry configuration
```

---

## 📖 Additional Resources

### RabbitMQ Documentation
- Official Docs: https://www.rabbitmq.com/documentation.html
- Spring AMQP Guide: https://docs.spring.io/spring-amqp/reference/

### Workflow Automation Concepts
- Event-Driven Architecture patterns
- Message queue best practices
- Distributed system design

---

## 🤝 Contributing

Contributions are welcome! Please follow these steps:

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/NewFeature`)
3. Commit your changes (`git commit -m 'Add NewFeature'`)
4. Push to the branch (`git push origin feature/NewFeature`)
5. Open a Pull Request

### Contribution Guidelines
- Follow existing code style
- Add unit tests for new features
- Update documentation
- Test RabbitMQ integration thoroughly

---

## 📄 License

This project is open source and available under the [MIT License](LICENSE).

---

## 👤 Contact

**Swagatika Samal**

- 💼 LinkedIn: [linkedin.com/in/swagatika-samal-7762432ba](https://linkedin.com/in/swagatika-samal-7762432ba)
- 📧 Email: swagatika91575@gmail.com
- 🐙 GitHub: [@swagatika190](https://github.com/swagatika190)

---

## ⭐ Show Your Support

If you found this project interesting or helpful, please give it a ⭐ star on GitHub!

---

## 🙏 Acknowledgments

- Inspired by enterprise workflow automation tools like Apache Airflow, Temporal, and Camunda
- RabbitMQ for reliable message queuing
- Spring Boot ecosystem for rapid development
- Open-source community for continuous learning

---

## 📊 Project Statistics

- **Lines of Code:** ~5000+
- **Number of Entities:** 5
- **API Endpoints:** 20+
- **RabbitMQ Queues:** 3
- **Database Tables:** 4
- **Development Time:** 2 months

---

**Built with ❤️ by Swagatika Samal**

*Empowering business process automation through distributed, message-driven architecture*
