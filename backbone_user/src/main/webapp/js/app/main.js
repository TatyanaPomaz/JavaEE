window.User = Backbone.Model.extend({
    urlRoot: "rest/users/",
    defaults: {
        "id": null,
        "name": "",
        "age": ""
    }
});

window.UserCollection = Backbone.Collection.extend({
    model: User,
    url: "rest/users/"
});

window.UserListView = Backbone.View.extend({

    el: $('#userList'),

    initialize: function () {
        this.model.bind("add", function (user) {
            $('#userList').append(new UserListItemView({model: user}).render().el);
        });
    },

    render: function (eventName) {
        _.each(this.model.models, function (user) {
            $(this.el).append(new UserListItemView({model: user}).render().el);
        }, this);
        return this;
    }
});

window.UserListItemView = Backbone.View.extend({

    tagName: "li",

    template: _.template($('#user-list-item').html()),

    initialize: function () {
        this.model.bind("change", this.render, this);
        this.model.bind("destroy", this.close, this);
    },

    render: function (eventName) {
        $(this.el).html(this.template(this.model.toJSON()));
        return this;
    },

    close: function () {
        $(this.el).unbind();
        $(this.el).remove();
    }
});

window.UserView = Backbone.View.extend({

    el: $('#mainArea'),

    template: _.template($('#user-details').html()),

    initialize: function () {
        this.model.bind("change", this.render, this);
    },

    render: function (eventName) {
        $(this.el).html(this.template(this.model.toJSON()));
        return this;
    },

    events: {
        "change input": "change",
        "click .save": "saveUser",
        "click .delete": "deleteUser"
    },

    change: function (event) {
        var target = event.target;
        console.log('changing ' + target.id + ' from: ' + target.defaultValue + ' to: ' + target.value);
    },

    saveUser: function () {
        this.model.set({
            name: $('#name').val(),
            age: $('#age').val(),
        });
        if (this.model.isNew()) {
            var self = this;
            app.userList.create(this.model, {
                success: function () {
                    app.navigate('users/' + self.model.id, false);
                }
            });
        } else {
            this.model.save();
        }

        return false;
    },

    deleteUser: function () {
        //$.ajax({
        //    type: "get",
        //    url: "/user/rest/users/delete/" + this.model.id, //your valid url
        //    success: function (result) {
        //        alert("success");
        //        app.list();
        //        app.newUser();
        //    },
        //    error: function () {
        //      alert("error");
        //    }
        //});
        this.model.destroy({
            success:function () {
                alert('User deleted successfully');
                window.history.back();
            }
        });
        return false;
    },

    close: function () {
        $(this.el).unbind();
        $(this.el).empty();
    }
});

window.HeaderView = Backbone.View.extend({

    el: $('.header'),

    template: _.template($('#header').html()),

    initialize: function () {
        this.render();
    },

    render: function (eventName) {
        $(this.el).html(this.template());
        return this;
    },

    events: {
        "click .new": "newUser"
    },

    newUser: function (event) {
        app.navigate("users/new", true);
        return false;
    }
});

var AppRouter = Backbone.Router.extend({

    routes: {
        "": "list",
        "users/new": "newUser",
        "users/:id": "userDetails"
    },

    list: function () {
        this.userList = new UserCollection();
        var self = this;
        this.userList.fetch({
            success: function () {
                self.userListView = new UserListView({model: self.userList});
                self.userListView.render();
                if (self.requestedId) self.userDetails(self.requestedId);
            }
        });
    },

    userDetails: function (id) {
        if (this.userList) {
            this.user = this.userList.get(id);
            if (this.userView) this.userView.close();
            this.userView = new UserView({model: this.user});
            this.userView.render();
        } else {
            this.requestedId = id;
            this.list();
        }
    },

    newUser: function () {
        if (app.userView) app.userView.close();
        app.userView = new UserView({model: new User()});
        app.userView.render();
    }

});

var app = new AppRouter();
Backbone.history.start();
var header = new HeaderView();