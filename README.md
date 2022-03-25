# Songr app

- I created this app by [Spring Initializer](https://start.spring.io/).
- You can run this app and then open the localhost url by this port 8080 .  
   - for Home page : (http://localhost:8080/) .
   - for hello world page : (http://localhost:8080/hello) .
   - for capitalizer page : (http://localhost:8080/capitalize/word).
   - for albums page : (http://localhost:8080/albums)
   - to add album in the albums page : (http://localhost:8080/addAlbum)
   - for songs page : (http://localhost:8080/songs)  
   - for songs in a specific album (with its id) : (http://localhost:8080/albums/{id}/songs)  
   - for add songs (for a specific album id) : (http://localhost:8080/addSong/{id})
- At first, you can add albums at (/addAlbum) then we click on submit button, it will move us to (/albums) page . the albums' page contain a small form to add songs to a specific album by its id, when we write the id and click submit it will move us to (/addSong/{id}) page, then write the song info and click submit then it will move us to (/albums/{id}/songs) page.

- before we run our code we should start the postgres server by **sqlstart** command. and then we can connect to our database or create a database if we didn't create it before by **psql** command, and then we can run our application and see our table that is generated from the application.