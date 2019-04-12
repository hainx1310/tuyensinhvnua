/**
 * @license Copyright (c) 2003-2019, CKSource - Frederico Knabben. All rights reserved.
 * For licensing, see https://ckeditor.com/legal/ckeditor-oss-license
 */

CKEDITOR.editorConfig = function( config ) {
	// Define changes to default configuration here. For example:
	// config.language = 'fr';
	// config.uiColor = '#AADC6E';
	config.toolbar = [
        { name: 'save', items: [ 'savebtn','Undo','Redo' ] },
        { name: 'clipboard', items: [ 'Cut','Copy','Paste','PasteText','PasteFromWord'] },
        { name: 'document', items: [ 'Find','Replace'] },
        { name: 'lists', items: [ 'NumberedList','BulletedList','Outdent','Indent'] },
        { name: 'insert', items: [ 'Image','Table','Smiley','SpecialChar'] },
        { name: 'link', items: ['Link','Unlink'] },
        '/',
        { name: 'basicstyles', items: [ 'Font','FontSize','Bold','Italic','Underline','Strike','Subscript','Superscript'] },
        //'/',
        { name: 'align', items: [ 'JustifyLeft','JustifyCenter','JustifyRight','JustifyBlock'] }
    ];
	
	config.height = 300;
};
