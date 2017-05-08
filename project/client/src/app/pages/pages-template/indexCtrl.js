/**
 * @author
 * created on 16.12.2015
 */
(function () {
  'use strict';

  angular.module('BlurAdmin.pages.customer')
      .controller('customerCtrl', customerCtrl);

  /** @ngInject */
  function customerCtrl($scope, Restangular, DTOptionsBuilder, DTColumnDefBuilder,defaultOptionsDom) {

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



    vm.addCustomer = addCustomer;
    vm.modifyCustomer = modifyCustomer;
    vm.removeCustomer = removeCustomer;
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

    function addCustomer() {
      //vm.Customers.push(angular.copy(vm.Customer2Add));
      //vm.Customer2Add = _buildCustomer2Add(vm.Customer2Add.id + 1);
    }
    function modifyCustomer(index) {

    }
    function removeCustomer(index) {
      //vm.customers.splice(index, 1);
    }


    function init(){
      loadData();
    }
    init();


  }

})();
