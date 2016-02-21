(function (window, $, undefined) {
    'use strict';

    var marksplugin;

    marksplugin = function marksplugin(cockpit) {
        console.log("Loading marks fantastic plugin.");

        // Instance variables
        this.cockpit = cockpit;
        this.level = 100;

        // Add required UI elements
        $(".header-container .wrapper").prepend('<div id="marksplugin"><canvas class="gauge" width="50px;" height="25px;" /><span class="level">100%</span></div>');
        this.ctx = $('#marksplugin .gauge').get(0).getContext('2d');

        // Initial draw
        this.draw();
    };
/*
    marksplugin.prototype.draw = function() {
        var cw = this.ctx.canvas.width;
        var ch = this.ctx.canvas.height;
		
        this.ctx.clearRect(0, 0, cw, ch);
        this.ctx.save();
        this.ctx.strokeStyle = 'grey';
        this.ctx.fillStyle = 'grey';
        this.ctx.lineWidth = 2;
        roundRect(this.ctx, 5, 1, 40, 20);
        this.ctx.fillRect(45, 5, 4, 12);
        
        var width = Math.floor(this.level / 100 * 35);
        this.ctx.fillStyle = this.getColor();
        roundRect(this.ctx, 8, 3, width, 15, 3, true, false);
        
        this.ctx.restore();
    }*/

    window.Cockpit.plugins.push(marksplugin);

}(window, jQuery));
