# YoutubeAudioExtractor

Spring Boot app(embedded server) that relies on youtube-dl shell app to download and extract audio from video.

To generate artifact:

 1.- `mvn clean install` fro the troot of the project.
 
 To extend the file permissions:
 
 2.- `chmod 777 ./target/<youtubeAudioExtractor>.jar`
 Note that there might be permission issues if no permission is given to the generated artifact. Since the artifact will need to perform write operations on disk.
 
 To run the app/server:
 
 3.- `java -jar <youtubeAudioExtractor>.jar`
 
 Endpoints exposed:
 
 /youtube/{youtubeVideoId}
 
 Given https://www.youtube.com/watch?v=4qJXTR7SyBQ&list=RD4qJXTR7SyBQ => id = 4qJXTR7SyBQ&list=RD4qJXTR7SyBQ
