function video(name, deps) {
    
    var fs = require('fs'); // node filesystem tools
    var latestImage;
    var counter = 0; // keeps track of the frames being saved and maintains order    
    var lastFrameTime = 0; // baseline to compare time of last capture against with delay inc
    var delay = 3000; // program takes a png of drones view every 3s and stores on laptop    

    // Add a new route to fetch camera image
    deps.app.get('/camera/:id', function(req, res) {
      if (!latestImage) {
          res.writeHead(301, {"Location": "/plugin/" + name + "/images/nofeed.jpg"});
          res.end();
          return;
      }
     
      res.writeHead(200, {'Content-Type': 'image/png'});
      return res.end(latestImage, "binary");
    });
    
    // Add a handler on images update
    deps.client.getPngStream()
      .on('error', console.log)
      .on('data', function(frame) {
        latestImage = frame;

        // added code to save PNGs to laptop/GCS every X seconds according to delay variable
        var currentTime = (new Date()).getTime();
        if (currentTime - lastFrameTime > delay){
            counter++;
            lastFrameTime = currentTime;
            console.log('Processing current frame...');
            fs.writeFile('droneimages\\frame' + counter + '.png', frame, function(err){
                if (err){
                    console.log('error saving frame as png');
                } 
                else{
                    console.log('current frame saved as png in the droneimages folder');
                }
            });
        }  
        
            
    }); 
    
    
    /*
    // MIGHT NOT BE REQUIRED ANY MORE
    // Creating custom function to be called when user clicks "p" from the pilot.js file
    this.takePic = function(){
        console.log("takePic called");
        fs.writeFile('droneimages\\fframe1',latestImage, function(err){
            if (err){
                    console.log('error saving frame as png');
                } 
            else{
                    console.log('current frame saved as png in the droneimages folder');
                } 
        });
 
    };
    */
};

module.exports = video;
