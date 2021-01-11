import React from 'react'
import Messenger from './components/Messenger'
import './Chat.css'

export default function Chat() {
    return (
        <div>
            <section className="navbar navbar-default navbar-static-top" role="navigation">
                <div className="container">

                    <div className="navbar-header">
                            <button className="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                                <span className="icon icon-bar"></span>
                                <span className="icon icon-bar"></span>
                                <span className="icon icon-bar"></span>
                            </button>

                            <a href="index.html" className="navbar-brand"><i className="fa fa-h-square"></i>ealth Center</a>
                    </div>

                    <div className="collapse navbar-collapse">
                            <ul className="nav navbar-nav navbar-right">
                                <li><a href="#top" className="smoothScroll">Home</a></li>
                                <li><a href="#about" className="smoothScroll">About Us</a></li>
                                <li><a href="#team" className="smoothScroll">Doctors</a></li>
                                <li><a href="#news" className="smoothScroll">News</a></li>
                                <li><a href="#google-map" className="smoothScroll">Contact</a></li>
                                <li className="appointment-btn"><a href="#appointment">Make an appointment</a></li>
                            </ul>
                    </div>

                </div>
            </section>
            <Messenger className="messenger" />
        </div>
    )
}
