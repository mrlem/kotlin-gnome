# Sample Glade GTK application

This sample demonstrates how to create a **GTK application** based on a **Glade** UI, using **Kotlin Native**.

![Screenshot](doc/readme-screenshot.png)

## Features

* a **lightweight GTK binding**: no wrapper objects (it looks more crude, but does the job)
* a gradle **glade view binding generator** (coming from android development, it feels like home)
* a sample app

They say a picture is worth a thousand words:

![Generator](doc/readme-generator.png)

## Status

* API coverage is progressing, though some things are sorely missed (lambda based signal handlers generation is next).
* the aim is to be able to fully generate the API through [GIR](https://gi.readthedocs.io) (most of what is already present is already generated).
* tested on Ubuntu 20.04

## Build

Prerequisites:

```bash
sudo apt install libgtk-3-dev libtinfo5
```

Then:

```bash
cd sample
../gradlew runDebugExecutableCommon
```

## Usage

See [sample](sample/src/commonMain/kotlin/org/mrlem/gtk/sample) module.

## See also

Other Kotlin native GTK bindings, both using a wrapper objects approach (more memory, but true inheritance), see either:
* [kotlin-native-gtk](https://github.com/kropp/kotlin-native-gtk): which features an API generator based on GIR
* [kotlinx-gtk](https://github.com/Doomsdayrs/kotlinx-gtk)

For an explanation about why I didn't rely on one of them, see the [FAQ](FAQ.md).

A tool to generate Java code from GIR repositories:
* https://github.com/gstreamer-java/gir2java
