/**
 * @author
 * created on 16.12.2015
 */
(function () {
  'use strict';

  angular.module('BlurAdmin.pages.customers')
      .controller('indexCtrl', indexCtrl);

  /** @ngInject */
  function indexCtrl($state, Restangular, DTOptionsBuilder, DTColumnDefBuilder,defaultOptionsDom) {

    var vm = this;


    vm.selected = {};
    vm.selectAll = false;
    vm.toggleAll = toggleAll;
    vm.toggleOne = toggleOne;
    function toggleAll (selectAll, selectedItems) {
      for (var id in selectedItems) {
        if (selectedItems.hasOwnProperty(id)) {
          selectedItems[id] = selectAll;
        }
      }
    }
    function toggleOne (selectedItems) {
      for (var id in selectedItems) {
        if (selectedItems.hasOwnProperty(id)) {
          if(!selectedItems[id]) {
            vm.selectAll = false;
            return;
          }
        }
      }
      vm.selectAll = true;
    }



    vm.create = create;
    vm.edit = edit;
    vm.destroy = destroy;
    vm.reloadData = reloadData;
    vm.loadData = loadData;



    vm.customers = [];
    vm.dtOptions = DTOptionsBuilder.newOptions()
        .withPaginationType('full_numbers')
        .withDOM(defaultOptionsDom)
        //.withDOM('<"row"<"col-xs-9 col-md-9"B><"col-xs-3 col-md-3"f>>rt<"row"<"col-md-3"l><"col-md-6"p><"col-md-3"i>>')
        // Active Buttons extension
        .withButtons([
          {
            text: 'Some button',
            className: 'btn btn-primary',
            key: '1',
            action: function (e, dt, node, config) {
              alert('Button activated');
            }
          },
          'copy',
          'print'
        ]);
    vm.dtColumnDefs = [
      DTColumnDefBuilder.newColumnDef(0).notSortable(),
      DTColumnDefBuilder.newColumnDef(1),
      DTColumnDefBuilder.newColumnDef(2),
      DTColumnDefBuilder.newColumnDef(3).notSortable()

    ];

    function loadData(){

      Restangular.all('customers').getList().then(function(customers) {
        vm.customers = customers;
        for (var index=0;index<customers.length;index++){
          vm.selected[index+1] = false;
        }


      });
    }

    function reloadData(){
      Restangular.all('customers').getList().then(function(customers) {
        vm.customers = customers;

      });
    }

    function create(){

    }

    function edit(index){
      $state.go('customers.edit',{"id":vm.customers[index].partyId});
    }

    function destroy(index){

    }
    //
    //function add() {
    //  //vm.Customers.push(angular.copy(vm.Customer2Add));
    //  //vm.Customer2Add = _buildCustomer2Add(vm.Customer2Add.id + 1);
    //}
    //function modify(index) {
    //
    //}
    //function remove(index) {
    //  //vm.customers.splice(index, 1);
    //}


    function init(){
      loadData();
    }
    init();


  }

})();
