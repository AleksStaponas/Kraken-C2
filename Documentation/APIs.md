
# **Total APIs: 15**

- This is a list of all the current APIs in Kraken-C2, it’s still in development so things might change.
- **Disclaimer!**: Not all of the APIs are fully secured yet, so make sure you run this in a safe environment.

| **API Endpoint**                    | **HTTP Method** |
| ----------------------------------- | --------------- |
| `/api/findAllDevices`               | GET             |
| `/api/findAllActiveDevices`         | GET             |
| `/api/file`                         | POST            |
| `/api/file/{id}`                    | GET             |
| `/api/file`                         | GET             |
| `/api/file/{id}`                    | DELETE          |
| `/api/terminal/run`                 | POST            |
| `/api/auth/validateToken`           | POST            |
| `/api/auth/signup`                  | POST            |
| `/api/auth/login`                   | POST            |
| `/api/auth/logout`                  | POST            |
| `/api/files/download/{filename:.+}` | GET             |
| `/api/files/upload`                 | POST            |
| `/api/files/list`                   | GET             |
| `/api/files/delete/{fileName}`      | POST            |