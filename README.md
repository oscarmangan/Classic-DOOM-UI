# SciFi UI Project

Name: Oscar Mangan

Student Number: C17486986

# Description of the assignment

The user interface I made is based and inspired on the original DOOM series video games from the early 1990s. The interface opens, and has several animated objects appearing on screen. The overall colour palette is red, as the same as the old games. The UI, along with the animations and drawings, will display a slideshow of the images of the enemies encountered in the DOOM games. 

A button menu at the top of the UI will allow users to select a demon, and display it's statistics; Name, Health Points, Attack Points, Special Attack name, and the origin of the demon. When the user selects a demon, it also displays an image, from the original game, of said demon in a image box to the left of the information box.

There is animation, in the 2 radars, 4 spinners, and the red circles which move up and down. There is also a rage meter, a small nod to the meme that the protagonist from DOOM, 'Doomguy' is "literally too angry to die". When the space button is pressed, the rage meter bar fills up. As well as this, the radars and spinners speed up, until SPACE is released.

# Instructions

Upon opening the UI, no demons image or information will be on display. Only upon using the mouse cursor, and clicking on the buttons, does the image and information of each demon display. If the user clicks on another demon button, the previous information and image is replaced by the current one.

If the user presses the SPACE bar, the rage meter at the bottom of the UI will fill up, causing the spinning animations to speed up and spin faster. Upon releasing the SPACE bar, the spinning animations will return back to normal speed.

There is a small text box at the bottom of the UI to give the user the control guide.

# How it works

The main class is used to Run the UI class by calling and instantiating it. The UI class, also declares and instantiates the classes Radar, Spinner, Circle, Rage and uses the Demon class in an ArrayList. Inside

# What I am most proud of in the assignment

# Markdown Tutorial

This is *emphasis*

This is a bulleted list

- Item
- Item

This is a numbered list

1. Item
1. Item

This is a [hyperlink](http://bryanduggan.org)

# Headings
## Headings
#### Headings
##### Headings

This is code:

```Java
public void render()
{
	ui.noFill();
	ui.stroke(255);
	ui.rect(x, y, width, height);
	ui.textAlign(PApplet.CENTER, PApplet.CENTER);
	ui.text(text, x + width * 0.5f, y + height * 0.5f);
}
```

So is this without specifying the language:

```
public void render()
{
	ui.noFill();
	ui.stroke(255);
	ui.rect(x, y, width, height);
	ui.textAlign(PApplet.CENTER, PApplet.CENTER);
	ui.text(text, x + width * 0.5f, y + height * 0.5f);
}
```

This is an image using a relative URL:

![An image](images/p8.png)

This is an image using an absolute URL:

![A different image](https://bryanduggandotorg.files.wordpress.com/2019/02/infinite-forms-00045.png?w=595&h=&zoom=2)

This is a youtube video:

[![YouTube](http://img.youtube.com/vi/J2kHSSFA4NU/0.jpg)](https://www.youtube.com/watch?v=J2kHSSFA4NU)

This is a table:

| Heading 1 | Heading 2 |
|-----------|-----------|
|Some stuff | Some more stuff in this column |
|Some stuff | Some more stuff in this column |
|Some stuff | Some more stuff in this column |
|Some stuff | Some more stuff in this column |

