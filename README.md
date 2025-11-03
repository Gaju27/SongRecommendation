
---

# 🎵 SongRecommendation

A **Spring Boot–based Song Recommendation System** powered by **Spring AI** and **Ollama**.
This project leverages **AI-driven natural language processing** to recommend songs based on your **mood, genre**, or **preferences**.
It is designed to work with both **local AI models (like Ollama)** and **cloud-based LLMs**, but currently uses a **local Ollama model** for accessibility and to avoid paid subscriptions during development.

---

## 🚀 Features

* 🤖 **Spring AI Integration** — unified interface to interact with local or cloud-based LLMs.
* 💡 **Flexible AI Backend** — supports **Ollama (local)** and can be easily configured for OpenAI, Anthropic, or others.
* 🎧 **Natural Language Recommendations** — describe your mood or favorite artist, and get intelligent song suggestions.
* 🧱 **Modular Spring Boot Architecture** — cleanly separates controller, service, and AI layers.
* 🧪 **Gradle Build System** — for reliable builds and dependency management.

---

## 🧠 How It Works

1. The user provides a natural language prompt (e.g. “Recommend 5 relaxing acoustic songs”).
2. The application sends that prompt to **Spring AI**, which routes it to the configured model backend (Ollama in this case).
3. The AI model generates song suggestions in text form.
4. The Spring Boot service parses and returns the structured recommendations to the client.

---

## 🏗️ Tech Stack

| Component       | Description                                    |
| --------------- | ---------------------------------------------- |
| **Java 17+**    | Core language                                  |
| **Spring Boot** | Application framework                          |
| **Spring AI**   | AI abstraction layer (local or cloud models)   |
| **Ollama**      | Local model runtime for Llama 3, Mistral, etc. |
| **Gradle**      | Build and dependency management                |
| **REST APIs**   | For client communication                       |

---

## ⚙️ Prerequisites

* Java 17 or newer
* Gradle (or Gradle wrapper)
* [Ollama](https://ollama.ai) installed locally
* (Optional) Cloud model credentials (e.g., OpenAI API key)

You can install and set up Ollama:

```bash
curl -fsSL https://ollama.com/install.sh | sh
ollama pull llama3
```

---

## 🚀 Setup and Run

1. **Clone the repository**

   ```bash
   git clone https://github.com/Gaju27/SongRecommendation.git
   cd SongRecommendation
   ```

2. **Start Ollama locally**

   ```bash
   ollama serve
   ```

3. **Run the Spring Boot app**

   ```bash
   ./gradlew bootRun
   ```

4. **Send a request**

   ```
   POST http://localhost:8080/api/song/v1/recommendations
   {
      "mood": "Delight",
      "limit": 3
   }
  ```

---

## 🧩 Example Response

```json
[
  {
    "title": "Spaceships on Sunsets",
    "artist": "Post Malone",
    "album": "Unreleased Songs",
    "genre": "Rock",
    "releaseYear": 1970,
    "motivation": "Incorporates sunset imagery suggesting a positive and joyful vibe"
  },
  {
    "title": "Monta",
    "artist": "Post Malone",
    "album": "August 26th",
    "genre": "Pop",
    "releaseYear": 2016,
    "motivation": "Pop genre and catchy melody create a cheerful atmosphere"
  },
  {
    "title": "Psycho",
    "artist": "Post Malone",
    "album": "beerbongs & bentleys",
    "genre": "Pop",
    "releaseYear": 2018,
    "motivation": "Upbeat tempo and positive lyrics contribute to the delight mood"
  }
]
```

---

## ⚙️ Configuration

Configure the AI model backend in `application.yml`:

```yaml
spring:
  ai:
    ollama:
      base-url: http://localhost:11434
      model: llama3
recommendation:
  max-results: 5
```

👉 To switch to a cloud-based provider (like OpenAI or Azure OpenAI), just update your `spring.ai` configuration accordingly — the same code works without any code-level changes.

---

## 📂 Project Structure

```
/
├─ src/
│  ├─ main/java/com/example/songrecommendation/
│  │   ├─ controller/    # REST endpoints
│  │   ├─ service/       # AI and recommendation logic
│  │   └─ model/         # Request/response objects
│  └─ test/java/         # Unit tests
├─ build.gradle
├─ settings.gradle
├─ .gitignore
└─ README.md
```

---

## 🧩 Extending the Project

* Add cloud-based AI models like OpenAI GPT, Anthropic Claude, or Azure OpenAI.
* Integrate real-time song data using Spotify or YouTube APIs.
* Improve parsing logic for structured AI output.
* Add a web frontend for an interactive UI.

---

## 🤝 Contributing

Contributions are welcome!

1. Fork the repo
2. Create a feature branch
3. Commit your changes
4. Push to your branch
5. Open a Pull Request

---

