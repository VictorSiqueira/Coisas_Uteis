/*jslint latedef:false*/
describe("A suite", function () {
    beforeEach( module('miAp'));
    
    var telMsDF;
    
    beforeEach(inject(function ($filter){
        telMsDF = $filter('telMXDF');
    }));
    
    it("contains spec with an expectation", function () {
        var tel = '5512345678'; 
        expect(telMsDF(tel)).toBe('(55) 1234-5678');
    });
});