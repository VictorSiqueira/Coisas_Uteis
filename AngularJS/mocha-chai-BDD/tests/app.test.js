var expect = chai.expect;

describe('Todo Controller', function() {
    
    var scope, control;
    
    beforeEach(angular.mock.module('app'));
    beforeEach(inject(function($rootScope, $controller) {
        scope = $rootScope.$new();
        control = $controller('TodoController', {$scope : scope});
    }))
    
    describe('Add todos', function (){
        it('Should be add todo on list', function(){
            var oldLen = scope.todos.length;
            scope.addTodo('Comprar pão' , false);                   
            var newLeng = scope.todos.length;   
            expect(oldLen).to.equal(newLeng - 1);
        });
    });
});